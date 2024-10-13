package com.debt.service.service;

import com.debt.service.common.TransactionTypeEnum;
import com.debt.service.entity.TransactionEntity;
import com.debt.service.model.base.SimplePage;
import com.debt.service.model.request.TransactionRequest;
import com.debt.service.model.response.CalcTransactionResponse;
import com.debt.service.model.response.TransactionResponse;

import java.util.Date;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 3:41 PM
 */
public interface TransactionService {
    TransactionEntity create(TransactionRequest request);

    SimplePage<TransactionResponse> gets(Date startDate, Date endDate, TransactionTypeEnum type, String category, int page, int size);

    CalcTransactionResponse accurateTransactionInRange(Date startDate, Date endDate, TransactionTypeEnum type, String category);
}
