package com.fpt.fsa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "bill")
@ToString
public class Bill {
    @Id
    @Column(name = "bill_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billNumber;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    @OneToOne(mappedBy = "bill")
    private Appointment appointment;

    @OneToMany(mappedBy = "bill")
    private Set<Payment> listPayment;

}
