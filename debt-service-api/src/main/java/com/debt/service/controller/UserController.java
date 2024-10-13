package com.debt.service.controller;

import com.debt.service.common.StatusCodeEnum;
import com.debt.service.model.base.ResponseApi;
import com.debt.service.model.request.CreateAccountRequest;
import com.debt.service.model.response.AccountInformationResponse;
import com.debt.service.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:03 PM
 */
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<ResponseApi<AccountInformationResponse>> getAccount(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());

        return ResponseEntity.ok()
                .body(ResponseApi.<AccountInformationResponse>builder()
                        .status(StatusCodeEnum.SUCCESS.getStatusCode())
                        .message(StatusCodeEnum.SUCCESS.getMessage())
                        .data(userService.get(userDetails.getUsername()))
                        .build());
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseApi<String>> createAccount(@Valid @NonNull @RequestBody CreateAccountRequest createAccountRequest) {

        return ResponseEntity.badRequest()
                .body(ResponseApi.<String>builder()
                        .status(StatusCodeEnum.INSERT_FAILED.getStatusCode())
                        .message(StatusCodeEnum.INSERT_FAILED.getMessage())
                        .data(null)
                        .build());
    }

    @GetMapping("/accounts")
    public ResponseEntity<ResponseApi<String>> getAccounts() {

        return ResponseEntity.badRequest()
                .body(ResponseApi.<String>builder()
                        .status(StatusCodeEnum.INSERT_FAILED.getStatusCode())
                        .message(StatusCodeEnum.INSERT_FAILED.getMessage())
                        .data(null)
                        .build());
    }
}
