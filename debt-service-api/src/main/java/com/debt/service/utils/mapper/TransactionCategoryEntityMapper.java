package com.debt.service.utils.mapper;

import com.debt.service.common.TransactionCategoryEnum;
import com.debt.service.entity.TransactionCategoryEntity;
import com.debt.service.model.request.TransactionCategoryRequest;
import org.mapstruct.Mapper;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 2:01 PM
 */
@Mapper(componentModel = "spring", uses = TransactionCategoryEnum.class)
public interface TransactionCategoryEntityMapper {
    TransactionCategoryEntity sourceToDestination(TransactionCategoryRequest source);

}
