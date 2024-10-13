package com.debt.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 10:45 AM
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FindingDataNotFoundException extends RuntimeException {
    public FindingDataNotFoundException() {
        super();
    }

    public FindingDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindingDataNotFoundException(String message) {
        super(message);
    }

    public FindingDataNotFoundException(Throwable cause) {
        super(cause);
    }
}
