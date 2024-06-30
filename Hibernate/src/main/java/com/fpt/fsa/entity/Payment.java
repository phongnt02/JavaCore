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
@Table(name = "payment")
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_num")
    private Long receiptnum;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String method;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "bill_number")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "pat_Id")
    private Patient patient;

}