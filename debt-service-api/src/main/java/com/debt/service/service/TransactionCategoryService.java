package com.debt.service.service;

import com.debt.service.common.TransactionCategoryEnum;
import com.debt.service.entity.TransactionCategoryEntity;
import com.debt.service.model.base.SimplePage;
import com.debt.service.model.request.TransactionCategoryRequest;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 1:56 PM
 */
public interface TransactionCategoryService {
    TransactionCategoryEntity createTransactionCategory(TransactionCategoryRequest payload);
    TransactionCategoryEntity getTransactionCategory(Integer id);
    SimplePage<TransactionCategoryEntity> getsTransactionCategory(TransactionCategoryEnum type, String keyword, int page, int size);
}
