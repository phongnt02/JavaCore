package com.debt.service.controller;

import com.debt.service.common.StatusCodeEnum;
import com.debt.service.exception.UnAuthorizedException;
import com.debt.service.model.base.ResponseApi;
import com.debt.service.model.request.CreateAccountRequest;
import com.debt.service.model.request.LoginRequest;
import com.debt.service.model.response.LoginResponse;
import com.debt.service.service.AuthService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 9:55 AM
 */
@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseApi<LoginResponse>> login(@Valid @RequestBody LoginRequest payload) {
        LoginResponse response = authService.login(payload);
        if (Objects.isNull(response)) {
            throw new UnAuthorizedException();
        }

        return ResponseEntity.ok(ResponseApi.<LoginResponse>builder()
                .status(StatusCodeEnum.SUCCESS.getStatusCode())
                .message(StatusCodeEnum.SUCCESS.getMessage())
                .data(response)
                .build());
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseApi<String>> createAccount(@Valid @NonNull @RequestBody CreateAccountRequest createAccountRequest) {
        if (authService.createAccount(createAccountRequest)) {
            return ResponseEntity.ok(ResponseApi.<String>builder()
                    .status(StatusCodeEnum.SUCCESS.getStatusCode())
                    .message(StatusCodeEnum.SUCCESS.getMessage())
                    .build());
        }

        return ResponseEntity.badRequest()
                .body(ResponseApi.<String>builder()
                        .status(StatusCodeEnum.INSERT_FAILED.getStatusCode())
                        .message(StatusCodeEnum.INSERT_FAILED.getMessage())
                        .build());
    }
}
