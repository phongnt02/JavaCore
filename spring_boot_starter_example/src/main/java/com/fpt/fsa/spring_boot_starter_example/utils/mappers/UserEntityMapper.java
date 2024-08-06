package com.fpt.fsa.spring_boot_starter_example.utils.mappers;

import com.fpt.fsa.spring_boot_starter_example.entity.UserEntity;
import com.fpt.fsa.spring_boot_starter_example.middleware.request.CreateAccountRequest;

public class UserEntityMapper {
    public UserEntity sourceToDestination(CreateAccountRequest createAccountRequest){
        UserEntity user = new UserEntity();
        user.setFullName(createAccountRequest.getFullName());
        user.setPhoneNumber(createAccountRequest.getPhoneNumber());
        user.setPassword(createAccountRequest.getPassword());
        return user;
    }
}
