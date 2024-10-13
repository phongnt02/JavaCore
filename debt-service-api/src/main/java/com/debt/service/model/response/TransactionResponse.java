package com.debt.service.model.response;

import com.debt.service.common.TransactionTypeEnum;
import com.debt.service.entity.TransactionCategoryEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author vi.trannguyenky
 * @since 6/28/2024 9:40 AM
 */
@Getter
@Setter
public class TransactionResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -1L;

    private Integer id;

    private Double amount;

    private String note;

    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    @ManyToOne(fetch = FetchType.LAZY)
    private TransactionCategoryEntity category;
}
