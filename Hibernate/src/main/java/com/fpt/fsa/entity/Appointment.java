package com.fpt.fsa.entity;

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
@Table(name = "Appointment")
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;

    private int duration;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "doc_number")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "pat_Id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "bill_number")
    private Bill bill;
}