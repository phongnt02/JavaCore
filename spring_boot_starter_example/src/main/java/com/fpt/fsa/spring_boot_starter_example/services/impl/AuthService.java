package com.fpt.fsa.spring_boot_starter_example.services.impl;

import com.fpt.fsa.spring_boot_starter_example.middleware.request.CreateAccountRequest;
import com.fpt.fsa.spring_boot_starter_example.repository.UserRepository;
import com.fpt.fsa.spring_boot_starter_example.utils.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public boolean createAccount(CreateAccountRequest payload){
        userRepository.save(userMapper.sourceToDestination(payload));
        return true;
    }
}
