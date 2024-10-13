package com.debt.service.common;

import lombok.Getter;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:14 PM
 */
@Getter
public enum StatusCodeEnum {
    SUCCESS(0, "Execute operation successfully"),
    INSERT_FAILED(1, "Execute save operation failed"),
    FIELDS_INVALID(-1, "Fields is invalid"),
    NOT_FOUND(-2, "Data is not found"),
    UNAUTHORIZED(401, "UN_AUTHORIZED"),
    SQL_OPERATION_FAILED(-3, "SQL executed operation failed");

    private int statusCode;
    private String message;

    StatusCodeEnum(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.message = msg;
    }
}
