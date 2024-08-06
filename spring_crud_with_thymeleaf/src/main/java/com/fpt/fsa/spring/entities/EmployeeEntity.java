package com.fpt.fsa.spring.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Setter
@Getter
@Entity
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeEntity extends BaseEntity{
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "employee_id")
    String employeeId;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "department_name")
    String departmentName;

    @Column(name = "remark")
    String remark;

    @OneToOne
    AccountEntity account;
}

