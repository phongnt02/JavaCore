package com.debt.service.validator.impl;

import com.debt.service.validator.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.logging.log4j.util.Strings;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:25 PM
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {
    private final char[] specialChars = new char[]{'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '?', '@', '~'};

    @Override
    public void initialize(Password constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String payload, ConstraintValidatorContext constraintValidatorContext) {
        if (payload == null || Strings.isBlank(payload)) return false;

        final String password = payload.trim();
        boolean aLowerCase = false;
        boolean anUpperCase = false;
        boolean aSpecialCase = false;
        boolean aDigit = false;
        final boolean lengthMoreThan8 = password.length() >= 8;
        final char[] charArray = password.toCharArray();

        for (char c : charArray) {
            if (c >= 65 && c <= 90) {
                anUpperCase = true;
                continue;
            }

            if (c >= 97 && c <= 122) {
                aLowerCase = true;
                continue;
            }

            if (c >= 49 && c <= 59) {
                aDigit = true;
                continue;
            }

            for (char specialChar : specialChars) {
                if (specialChar == c) {
                    aSpecialCase = true;
                    break;
                }
            }
        }

        return aSpecialCase && aDigit && aLowerCase && anUpperCase && lengthMoreThan8;
    }
}
