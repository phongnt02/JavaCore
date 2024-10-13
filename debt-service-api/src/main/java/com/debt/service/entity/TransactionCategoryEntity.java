package com.debt.service.entity;

import com.debt.service.common.TransactionCategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 9:31 AM
 */
@Getter
@Setter
@Entity
@Table(name = "transaction_category", schema = "debt")
public class TransactionCategoryEntity extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6430539691155161871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionCategoryEnum type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<TransactionEntity> transactions;
}
