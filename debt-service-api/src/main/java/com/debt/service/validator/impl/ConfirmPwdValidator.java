package com.debt.service.validator.impl;

import com.debt.service.model.request.CreateAccountRequest;
import com.debt.service.validator.ConfirmPwd;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:25 PM
 */
public class ConfirmPwdValidator implements ConstraintValidator<ConfirmPwd, CreateAccountRequest> {

    @Override
    public void initialize(ConfirmPwd constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CreateAccountRequest payload, ConstraintValidatorContext constraintValidatorContext) {
        return ! (payload == null || payload.getPassword() == null || payload.getConfirmPassword() == null || !payload.getPassword().equals(payload.getConfirmPassword()));
    }
}
