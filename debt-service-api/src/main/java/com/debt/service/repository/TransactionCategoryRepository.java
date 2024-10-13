package com.debt.service.repository;

import com.debt.service.common.TransactionCategoryEnum;
import com.debt.service.entity.TransactionCategoryEntity;
import com.debt.service.entity.meta.TransactionCategory_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 2:00 PM
 */
@Repository
public interface TransactionCategoryRepository extends JpaRepository<TransactionCategoryEntity, Integer>, JpaSpecificationExecutor<TransactionCategoryEntity> {

    static Specification<TransactionCategoryEntity> typeEqual(TransactionCategoryEnum type) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(TransactionCategory_.TYPE), type));
    }

    static Specification<TransactionCategoryEntity> nameLike(String name) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(TransactionCategory_.NAME), "%" + name + "%"));
    }

    static Specification<TransactionCategoryEntity> nameEqual(String name) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(TransactionCategory_.NAME), name));
    }
}
