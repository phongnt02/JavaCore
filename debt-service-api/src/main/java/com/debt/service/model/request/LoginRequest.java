package com.debt.service.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 9:57 AM
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoginRequest {
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String password;
}
