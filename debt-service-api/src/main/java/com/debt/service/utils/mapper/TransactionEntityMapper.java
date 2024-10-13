package com.debt.service.utils.mapper;

import com.debt.service.common.TransactionTypeEnum;
import com.debt.service.entity.TransactionEntity;
import com.debt.service.model.request.TransactionRequest;
import com.debt.service.model.response.TransactionResponse;
import org.mapstruct.Mapper;


/**
 * @author vi.trannguyenky
 * @since 6/27/2024 12:05 AM
 */
@Mapper(componentModel = "spring", uses = TransactionTypeEnum.class)
public interface TransactionEntityMapper {
    TransactionEntity sourceToDestination(TransactionRequest source);
    TransactionResponse sourceToDestination(TransactionEntity source);
}
