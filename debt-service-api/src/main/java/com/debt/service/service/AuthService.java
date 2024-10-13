package com.debt.service.service;

import com.debt.service.model.request.CreateAccountRequest;
import com.debt.service.model.request.LoginRequest;
import com.debt.service.model.response.LoginResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 10:09 AM
 */
public interface AuthService extends UserDetailsService {
    boolean createAccount(CreateAccountRequest payload);

    LoginResponse login(LoginRequest payload);
}
