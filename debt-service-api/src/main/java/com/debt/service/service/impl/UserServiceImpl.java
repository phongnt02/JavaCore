package com.debt.service.service.impl;

import com.debt.service.entity.AccountEntity;
import com.debt.service.exception.FindingDataNotFoundException;
import com.debt.service.model.response.AccountInformationResponse;
import com.debt.service.repository.AccountRepository;
import com.debt.service.service.UserService;
import com.debt.service.utils.mapper.AccountEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 12:02 AM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AccountRepository accountRepository;
    private final AccountEntityMapper mapper;

    @Override
    public AccountInformationResponse get(String phoneNumber) {
        AccountEntity accountEntity = accountRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(FindingDataNotFoundException::new);
        return mapper.sourceToDestination(accountEntity);
    }
}
