package com.fpt.fsa.fa.training.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Computer")
@ToString
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private int computerId;

    @Column(name = "computer_name", length = 255)
    private String computerName;

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "price", columnDefinition = "DECIMAL(11, 2)")
    private double price;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "model", length = 255)
    private String model;

    @Column(name = "produce_status")
    private int produceStatus;

    @Column(name = "remark", length = 255)
    private String remark;

    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufacturer doctor;
}
