package com.debt.service.model.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 11:12 AM
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class LoginResponse extends AccountInformationResponse {
    private String accessToken;
    private String refreshToken;
}
