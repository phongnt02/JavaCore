package com.debt.service.model.base;

import com.debt.service.common.StatusCodeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:05 PM
 */
@Getter
@Setter
@Builder
public class ResponseApi<T> {
    private int status;
    private String message;
    private Map<String, String> errors;
    private T data;
}
