package com.debt.service.utils.mapper;

import com.debt.service.entity.AccountEntity;
import com.debt.service.model.request.CreateAccountRequest;
import com.debt.service.model.response.AccountInformationResponse;
import org.mapstruct.Mapper;


/**
 * @author vi.trannguyenky
 * @since 6/27/2024 12:05 AM
 */
@Mapper(componentModel = "spring")
public interface AccountEntityMapper {
    AccountEntity sourceToDestination(CreateAccountRequest source);
    AccountInformationResponse sourceToDestination(AccountEntity source);
}
