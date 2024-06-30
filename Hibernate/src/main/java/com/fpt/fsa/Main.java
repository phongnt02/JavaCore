package com.fpt.fsa;

import com.fpt.fsa.dao.BillDAO;
import com.fpt.fsa.dao.DoctorDAO;
import com.fpt.fsa.dao.PatientDAO;
import com.fpt.fsa.dao.PaymentDAO;
import com.fpt.fsa.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DoctorDAO doctorDAO = new DoctorDAO();

        Doctor doctor = new Doctor();
        doctor.setFirstName("Joh");
        doctor.setLastName("Doe");

        List<Appointment> appointments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Appointment appointment = new Appointment();
            appointment.setDate(new Date());
            appointment.setTime(new Date());
            appointment.setDuration(30);
            appointment.setReason("Checkup");
            appointments.add(appointment);
        }

        doctorDAO.createDoctorWithAppointments(doctor, appointments);

        // search all bills with a specific bill_date
        BillDAO billDAO = new BillDAO();

        Date billDate = new Date(); // hoặc một ngày cụ thể
        List<Bill> bills = billDAO.findByBillDate(billDate);

        for (Bill bill : bills) {
            System.out.println("Bill Number: " + bill.getBillNumber() + ", Bill Date: " + bill.getDate() + ", Status: " + bill.getStatus());
        }

        // find all payment belong a specific bill
        PaymentDAO paymentDAO = new PaymentDAO();

        Long billNumber = 1L; // hoặc một số hóa đơn cụ thể
        List<Payment> payments = paymentDAO.findByBill(billNumber);

        for (Payment payment : payments) {
            System.out.println("Payment ID: " + payment.getReceiptnum() + ", Amount: " + payment.getAmount() + ", Method: " + payment.getMethod());
        }

        PatientDAO patientDAO = new PatientDAO();

        // Phân trang cho Patient
        int patientOffset = 0;
        int patientLimit = 10;
        List<Patient> pagedPatients = patientDAO.getPatientsPaging(patientOffset, patientLimit);
        System.out.println("Paged Patients:");
        for (Patient patient : pagedPatients) {
            System.out.println("Patient ID: " + patient.getPatId() + ", Name: " + patient.getFirstname() + " " + patient.getLastname());
        }

        // Phân trang cho Bill
        int billOffset = 0;
        int billLimit = 10;
        List<Bill> pagedBills = billDAO.getPagedBills(billOffset, billLimit);
        System.out.println("Paged Bills:");
        for (Bill bill : pagedBills) {
            System.out.println("Bill Number: " + bill.getBillNumber() + ", Bill Date: " + bill.getDate() + ", Status: " + bill.getStatus());
        }
    }
}
