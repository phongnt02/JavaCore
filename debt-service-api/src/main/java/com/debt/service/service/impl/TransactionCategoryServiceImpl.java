package com.debt.service.service.impl;

import com.debt.service.common.TransactionCategoryEnum;
import com.debt.service.entity.TransactionCategoryEntity;
import com.debt.service.exception.FindingDataNotFoundException;
import com.debt.service.model.base.SimplePage;
import com.debt.service.model.request.TransactionCategoryRequest;
import com.debt.service.repository.TransactionCategoryRepository;
import com.debt.service.service.TransactionCategoryService;
import com.debt.service.utils.mapper.TransactionCategoryEntityMapper;
import io.jsonwebtoken.lang.Strings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 1:56 PM
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionCategoryServiceImpl implements TransactionCategoryService {
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final TransactionCategoryEntityMapper mapper;

    @Override
    public TransactionCategoryEntity createTransactionCategory(TransactionCategoryRequest payload) {
        TransactionCategoryEntity entity = mapper.sourceToDestination(payload);
        try {
            return transactionCategoryRepository.save(entity);
        } catch (HibernateException e) {
            log.error("Save transaction category failed: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public TransactionCategoryEntity getTransactionCategory(Integer id) {
        return transactionCategoryRepository.findById(id).orElseThrow(FindingDataNotFoundException::new);
    }

    @Override
    public SimplePage<TransactionCategoryEntity> getsTransactionCategory(TransactionCategoryEnum type, String keyword, int page, int size) {
        Specification<TransactionCategoryEntity> specification = null;
        if (type != null) {
            specification = where(TransactionCategoryRepository.typeEqual(type));
        }

        if (Strings.hasLength(keyword)) {
            if (specification != null) {
                specification = specification.and(TransactionCategoryRepository.nameLike(keyword));
            } else {
                specification = where(TransactionCategoryRepository.nameLike(keyword));
            }
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<TransactionCategoryEntity> entityPageable = null;
        if (specification != null) {
            entityPageable = transactionCategoryRepository.findAll(specification, pageable);
        } else {
            entityPageable = transactionCategoryRepository.findAll(pageable);
        }

        return new SimplePage<>(entityPageable.getContent(), entityPageable.getPageable(), entityPageable.getTotalElements());
    }
}
