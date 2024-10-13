package com.debt.service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author vi.trannguyenky
 * @since 6/27/2024 1:43 PM
 */
@Getter
@Setter
@Entity
@Table(name = "account_session", schema = "debt")
public class AccountSession extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6430539691155161871L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private int id;

    @Column(name = "refresh_token", unique = true)
    private String refreshToken;

    private String device;

    @ManyToOne(fetch = FetchType.LAZY)
    private AccountEntity account;
}
