package com.fpt.fsa.dao;

import com.fpt.fsa.entity.Appointment;
import com.fpt.fsa.entity.Doctor;

import java.util.List;

public class DoctorDAO extends GenericDAO<Doctor, Long> {
    public DoctorDAO() {
        super(Doctor.class);
    }

    public void createDoctorWithAppointments(Doctor doctor, List<Appointment> appointments) {
        create(doctor);
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        for (Appointment appointment : appointments) {
            appointment.setDoctor(doctor);
            appointmentDAO.create(appointment);
        }
    }
}
