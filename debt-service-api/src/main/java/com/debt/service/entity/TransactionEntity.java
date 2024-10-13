package com.debt.service.entity;

import com.debt.service.common.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 9:26 AM
 */
@Entity
@Table(name = "transaction", schema = "debt")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class TransactionEntity extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6430539691155161871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Integer id;

    @Column(updatable = false, columnDefinition = "DECIMAL(12, 2)")
    private Double amount;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    @ManyToOne(fetch = FetchType.LAZY)
    private TransactionCategoryEntity category;
}
