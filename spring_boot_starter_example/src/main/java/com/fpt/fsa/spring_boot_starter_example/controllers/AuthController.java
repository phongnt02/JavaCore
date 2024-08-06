package com.fpt.fsa.spring_boot_starter_example.controllers;

import com.fpt.fsa.spring_boot_starter_example.middleware.request.CreateAccountRequest;
import com.fpt.fsa.spring_boot_starter_example.services.impl.AuthService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "register")
    private ResponseEntity<String> register (@Valid @NonNull @RequestBody CreateAccountRequest createAccountRequest) {
        authService.createAccount(createAccountRequest);

        return ResponseEntity.ok("200");
    }
}
