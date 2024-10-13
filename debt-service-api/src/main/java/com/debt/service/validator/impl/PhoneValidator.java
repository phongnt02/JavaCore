package com.debt.service.validator.impl;

import com.debt.service.validator.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.logging.log4j.util.Strings;

import java.util.regex.Pattern;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:25 PM
 */
public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {
    private final String REGEX = "(?:\\+84|084|0)[235789][0-9]{1,2}[0-9]{7}(?:[^\\d]+|$)";

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String payload, ConstraintValidatorContext constraintValidatorContext) {
        if (payload == null || Strings.isBlank(payload))
            return false;

        final String phoneNumber = payload.trim();
        final Pattern pattern = Pattern.compile(REGEX);

        return pattern.matcher(phoneNumber).find();
    }
}
