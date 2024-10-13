package com.debt.service.repository;

import com.debt.service.common.TransactionTypeEnum;
import com.debt.service.entity.TransactionEntity;
import com.debt.service.entity.meta.TransactionEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 2:00 PM
 */
@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer>, JpaSpecificationExecutor<TransactionEntity> {

    static Specification<TransactionEntity> hasCreatedAtInRange(Date startDate, Date endDate) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(TransactionEntity_.CREATED_AT), startDate, endDate));
    }

    static Specification<TransactionEntity> hasType(TransactionTypeEnum transactionTypeEnum) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(TransactionEntity_.TYPE), transactionTypeEnum));
    }

    static Specification<TransactionEntity> hasCategoryId(int categoryId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(TransactionEntity_.CATEGORY_ID), categoryId));
    }
}
