package com.debt.service.controller.exception;

import com.debt.service.common.StatusCodeEnum;
import com.debt.service.exception.FindingDataNotFoundException;
import com.debt.service.exception.PasswordNotMatchedException;
import com.debt.service.exception.UnAuthorizedException;
import com.debt.service.model.base.ResponseApi;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:11 PM
 */
@ControllerAdvice
public class ExceptionController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseApi<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });


        return ResponseApi.<String>builder()
                .status(StatusCodeEnum.FIELDS_INVALID.getStatusCode())
                .message(StatusCodeEnum.FIELDS_INVALID.getMessage())
                .data(null)
                .errors(errors)
                .build();
    }

    @ExceptionHandler(FindingDataNotFoundException.class)
    public ResponseApi<String> handleAccountNotFoundExceptions(FindingDataNotFoundException ex) {
        return ResponseApi.<String>builder()
                .status(StatusCodeEnum.NOT_FOUND.getStatusCode())
                .message(StatusCodeEnum.NOT_FOUND.getMessage() + ":" + ex.getMessage())
                .build();
    }

    @ExceptionHandler({PasswordNotMatchedException.class, UnAuthorizedException.class})
    public ResponseApi<String> handlePasswordNotMatchedExceptions(PasswordNotMatchedException ex) {
        return ResponseApi.<String>builder()
                .status(StatusCodeEnum.UNAUTHORIZED.getStatusCode())
                .message(StatusCodeEnum.UNAUTHORIZED.getMessage() + ":" + ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HibernateException.class)
    public ResponseApi<String> handleHibernateExceptions(HibernateException ex) {
        return ResponseApi.<String>builder()
                .status(StatusCodeEnum.SQL_OPERATION_FAILED.getStatusCode())
                .message(ex.getMessage())
                .data(null)
                .errors(null)
                .build();
    }

}
