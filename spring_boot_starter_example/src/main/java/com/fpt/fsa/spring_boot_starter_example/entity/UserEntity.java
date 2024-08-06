package com.fpt.fsa.spring_boot_starter_example.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(name = "full_name")
    String fullName;
    @Column(name = "phone_number", unique = true)
    String phoneNumber;
    String password;
    @Column(name = "is_active")
    boolean isActive;
    String role;

}
