package com.fpt.fsa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "doctor")
@ToString
public class Doctor {
    @Id
    @Column(name = "doc_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;

}
