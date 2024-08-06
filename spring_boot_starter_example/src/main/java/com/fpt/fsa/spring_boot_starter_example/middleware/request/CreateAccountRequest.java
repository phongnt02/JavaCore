package com.fpt.fsa.spring_boot_starter_example.middleware.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAccountRequest implements Serializable {
    @NotBlank(message = "Full Name is mandatory")
    String fullName;

    @NotBlank(message = "Phone Number is mandatory")
//    @PhoneNumber
    String phoneNumber;

    @NotBlank(message = "Password is mandatory")
//    @Password
    String password;

    @NotBlank(message = "Password is mandatory")
    String confirmPassword;
}
