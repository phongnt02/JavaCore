package com.debt.service.validator;

import com.debt.service.validator.impl.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:23 PM
 */
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "{account.password.valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
