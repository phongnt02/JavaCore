package com.fpt.fsa.dao;

import com.fpt.fsa.entity.Appointment;

public class AppointmentDAO extends GenericDAO<Appointment, Long> {
    public AppointmentDAO() {
        super(Appointment.class);
    }
}

