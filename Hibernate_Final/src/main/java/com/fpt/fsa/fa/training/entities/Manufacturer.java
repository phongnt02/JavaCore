package com.fpt.fsa.fa.training.entities;

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
@Table(name = "Manufacture")
@ToString
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacture_id")
    private int manufactureId;

    @Column(name = "short_name", length = 255)
    private String shortName;

    @Column(name = "full_name", length = 255)
    private String fullName;

    @Column(name = "contact", length = 255)
    private String contact;

    @OneToMany(mappedBy = "doctor")
    private Set<Computer> listComputers;
}
