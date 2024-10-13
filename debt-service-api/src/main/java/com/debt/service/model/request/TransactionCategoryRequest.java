package com.debt.service.model.request;

import com.debt.service.common.TransactionCategoryEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 1:57 PM
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionCategoryRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 5)
    private String name;

    @NotBlank
    @Size(min = 10)
    private String description;

    private TransactionCategoryEnum type;
}
