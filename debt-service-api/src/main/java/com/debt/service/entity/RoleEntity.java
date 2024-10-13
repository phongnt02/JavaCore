package com.debt.service.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 10:51 PM
 */
@Entity
@Table(name = "role", schema = "debt")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Integer id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<AccountEntity> accountEntities;
}
