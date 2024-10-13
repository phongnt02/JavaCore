package com.debt.service.service.impl;

import com.debt.service.common.RoleEnum;
import com.debt.service.entity.AccountEntity;
import com.debt.service.entity.AccountSession;
import com.debt.service.exception.FindingDataNotFoundException;
import com.debt.service.exception.PasswordNotMatchedException;
import com.debt.service.model.request.CreateAccountRequest;
import com.debt.service.model.request.LoginRequest;
import com.debt.service.model.response.LoginResponse;
import com.debt.service.repository.AccountRepository;
import com.debt.service.repository.AccountSessionRepository;
import com.debt.service.repository.RoleRepository;
import com.debt.service.service.AuthService;
import com.debt.service.utils.jwt.JwtTokenUtil;
import com.debt.service.utils.mapper.AccountEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 10:09 AM
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AccountEntityMapper accountEntityMapper;
    private final BCryptPasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AccountSessionRepository accountSessionRepository;

    @Value("${service.avatar-link-default}")
    private String avatarLink;

    @Value("${service.admin-token}")
    private String adminToken;

    @Override
    public boolean createAccount(CreateAccountRequest payload) {
        log.info("Starting create account: {}", payload);
        AccountEntity accountEntity = accountEntityMapper.sourceToDestination(payload);
        accountEntity.setCreatedBy("ADMIN");
        accountEntity.setUpdatedBy("ADMIN");
        if (Objects.nonNull(adminToken) && Objects.nonNull(payload.getAdminToken()) && payload.getAdminToken().equals(adminToken)) {
            accountEntity.setRole(roleRepository.getByName(RoleEnum.ADMIN.name()));
        } else {
            accountEntity.setRole(roleRepository.getByName(RoleEnum.USER.name()));
        }
        accountEntity.setAvatar(avatarLink);
        accountEntity.setPassword(encoder.encode(accountEntity.getPassword()));
        accountEntity = accountRepository.save(accountEntity);
        log.info("Completed create account: {}", accountEntity);

        return Objects.nonNull(accountEntity.getId());
    }

    @Override
    public LoginResponse login(LoginRequest payload) {
        AccountEntity account = accountRepository.findByPhoneNumber(payload.getPhoneNumber())
                .orElseThrow(FindingDataNotFoundException::new);

        if (!encoder.matches(payload.getPassword(), account.getPassword())) {
            throw new PasswordNotMatchedException();
        }

        // Move to mapper
        LoginResponse response = new LoginResponse();
        response.setId(account.getId());
        response.setAccessToken(jwtTokenUtil.generateAccessToken(account));
        response.setRefreshToken(jwtTokenUtil.generateRefreshToken(account));
        response.setFirstName(account.getFirstName());
        response.setLastName(account.getLastName());
        response.setPhoneNumber(account.getPhoneNumber());

        AccountSession accountSession = new AccountSession();
        accountSession.setRefreshToken(response.getRefreshToken());
        accountSession.setCreatedBy(account.getFullName());
        accountSession.setUpdatedBy(account.getFullName());
        accountSessionRepository.save(accountSession);

        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity user = accountRepository.findByPhoneNumber(username)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found: " + username));
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().getName());
        UserDetails userDetails = new User(user.getPhoneNumber(), user.getPassword(), true,
                true, true, true,
                Collections.singleton(authority));

        return userDetails;
    }
}
