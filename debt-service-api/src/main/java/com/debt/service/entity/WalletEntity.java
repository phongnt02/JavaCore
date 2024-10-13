package com.debt.service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 9:47 AM
 */
@Getter
@Setter
@Entity
@Table(name = "wallet", schema = "debt")
public class WalletEntity extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6430539691155161871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Integer id;

    @Column(name = "total_amount_in", columnDefinition = "DECIMAL(12,2) DEFAULT 0")
    private Double totalAmountsIn;

    @Column(name = "total_amount_out", columnDefinition = "DECIMAL(12,2) DEFAULT 0")
    private Double totalAmountsOut;

    @Column(name = "month_year", nullable = false)
    private String monthYear;
}
