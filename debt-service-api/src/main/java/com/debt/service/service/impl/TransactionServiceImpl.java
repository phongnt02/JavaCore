package com.debt.service.service.impl;

import com.debt.service.common.TransactionTypeEnum;
import com.debt.service.entity.TransactionCategoryEntity;
import com.debt.service.entity.TransactionEntity;
import com.debt.service.exception.FindingDataNotFoundException;
import com.debt.service.model.base.SimplePage;
import com.debt.service.model.request.TransactionRequest;
import com.debt.service.model.response.CalcTransactionResponse;
import com.debt.service.model.response.TransactionResponse;
import com.debt.service.repository.TransactionCategoryRepository;
import com.debt.service.repository.TransactionRepository;
import com.debt.service.service.TransactionService;
import com.debt.service.utils.mapper.TransactionEntityMapper;
import io.jsonwebtoken.lang.Strings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static com.debt.service.repository.TransactionCategoryRepository.nameEqual;
import static com.debt.service.repository.TransactionRepository.*;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 3:41 PM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionEntityMapper mapper;
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public synchronized TransactionEntity create(TransactionRequest request) {
        TransactionEntity entity = mapper.sourceToDestination(request);
        TransactionCategoryEntity category = transactionCategoryRepository.findOne(nameEqual(request.getTranCategory())).orElseThrow(FindingDataNotFoundException::new);

        entity.setCategory(category);
        if (request.getUsedAt() != null) {
            entity.setCreatedAt(Instant.ofEpochMilli(request.getUsedAt().getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime());
        }

        return transactionRepository.save(entity);
    }

    private Specification<TransactionEntity> buildSpecificationTransaction(Date startDate, Date endDate, TransactionTypeEnum type, String category) {
        Specification<TransactionEntity> specification = Specification.where(hasCreatedAtInRange(startDate, endDate));
        if (type != null) {
            specification.and(hasType(type));
        }

        if (Strings.hasLength(category)) {
            TransactionCategoryEntity categoryEntity = transactionCategoryRepository.findOne(nameEqual(category)).orElseThrow(FindingDataNotFoundException::new);

            specification.and(hasCategoryId(categoryEntity.getId()));
        }
        return specification;
    }

    @Override
    public SimplePage<TransactionResponse> gets(Date startDate, Date endDate, TransactionTypeEnum type, String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

        final Specification<TransactionEntity> specification = buildSpecificationTransaction(startDate, endDate, type, category);

        Page<TransactionEntity> transactions = transactionRepository.findAll(specification, pageable);
        return new SimplePage<>(transactions.getContent().stream().map(mapper::sourceToDestination).toList(), transactions.getPageable(), transactions.getTotalElements());
    }

    @Override
    public CalcTransactionResponse accurateTransactionInRange(Date startDate, Date endDate, TransactionTypeEnum type, String category) {
        Specification<TransactionEntity> specification = buildSpecificationTransaction(startDate, endDate, type, category);

        List<TransactionEntity> transactions = transactionRepository.findAll(specification);

        CalcTransactionResponse response = new CalcTransactionResponse();
        for (TransactionEntity transaction : transactions) {
            response.setNumberOfTransactions(response.getNumberOfTransactions() + 1);
            response.setTotalAmount(response.getTotalAmount() + transaction.getAmount());
        }

        response.setType(type);
        response.setCategory(category);
        return response;
    }
}
