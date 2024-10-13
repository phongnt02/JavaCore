package com.debt.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 10:45 AM
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class PasswordNotMatchedException extends RuntimeException {
    public PasswordNotMatchedException() {
        super();
    }

    public PasswordNotMatchedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchedException(String message) {
        super(message);
    }

    public PasswordNotMatchedException(Throwable cause) {
        super(cause);
    }
}
