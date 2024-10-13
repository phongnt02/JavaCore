package com.debt.service.model.request;

import com.debt.service.common.TransactionTypeEnum;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 3:39 PM
 */
@Getter
@Setter
public class TransactionRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Min(0)
    @DecimalMax("10,000,000,000.00")
    private Double amount;

    private String note;

    @NotNull
    private TransactionTypeEnum type;

    @NotNull
    private String tranCategory;

    private Date usedAt;
}
