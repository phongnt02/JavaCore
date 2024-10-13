package com.debt.service.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author vi.trannguyenky
 * @since 6/26/2024 10:42 PM
 */
@Entity
@Table(name = "account", schema = "debt")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class AccountEntity extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6430539691155161871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Transient //ignore column store to database
    private String fullName;

    @Column(name = "phone_number", length = 10, unique = true)
    private String phoneNumber;

    @Column(name = "phone_prefix", length = 5)
    private String phonePrefix;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String avatar;

    @ManyToOne(fetch = FetchType.EAGER)
    private RoleEntity role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<AccountSession> sessions;

    public String getFullName() {
        return String.format("%s %s", this.getLastName(), this.getFirstName());
    }
}
