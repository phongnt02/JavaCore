package com.fpt.fsa.spring.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Account")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String email;
    String password;
    boolean status;
}
