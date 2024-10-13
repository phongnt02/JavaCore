package com.debt.service.model.response;

import com.debt.service.common.TransactionTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 4:46 PM
 */
@Getter
@Setter
public class CalcTransactionResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private double totalAmount;

    private int numberOfTransactions;

    @NotNull
    private TransactionTypeEnum type;

    @NotNull
    private String category;

}
