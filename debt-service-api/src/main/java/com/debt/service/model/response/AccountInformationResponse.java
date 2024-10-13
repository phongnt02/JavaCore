package com.debt.service.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 9:23 AM
 */
@Getter
@Setter
public class AccountInformationResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String avatar;
}
