package com.debt.service.validator;

import com.debt.service.validator.impl.ConfirmPwdValidator;
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
@Constraint(validatedBy = ConfirmPwdValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPwd {
    String message() default "{account.password.confirm}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
