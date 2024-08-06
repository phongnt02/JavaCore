package com.fpt.fsa.spring_boot_starter_example.utils.mappers;

import com.fpt.fsa.spring_boot_starter_example.entity.UserEntity;
import com.fpt.fsa.spring_boot_starter_example.middleware.request.CreateAccountRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity sourceToDestination(CreateAccountRequest source);
}
