package com.debt.service.service;

import com.debt.service.model.response.AccountInformationResponse;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 12:02 AM
 */
public interface UserService {
    AccountInformationResponse get(String phoneNumber);
}
