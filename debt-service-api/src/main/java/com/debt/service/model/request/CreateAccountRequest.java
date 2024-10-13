package com.debt.service.model.request;

import com.debt.service.validator.ConfirmPwd;
import com.debt.service.validator.Password;
import com.debt.service.validator.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 11:07 PM
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ConfirmPwd
@ToString
public class CreateAccountRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "{account.firstname.not-blank}")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "Phone Number is mandatory")
    @PhoneNumber
    private String phoneNumber;

    @NotBlank(message = "Password is mandatory")
    @Password
    private String password;

    @NotBlank(message = "Password is mandatory")
    private String confirmPassword;

    private String adminToken;
}
