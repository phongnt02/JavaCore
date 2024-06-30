package com.fpt.fsa.dao;

import com.fpt.fsa.entity.Patient;
import com.fpt.fsa.untils.HibernateUntils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class PatientDAO extends GenericDAO<Patient, Long> {
    public PatientDAO() {
        super(Patient.class);
    }

    public List<Patient> getPatientsPaging(int page, int pageSize) {
        List<Patient> patients = null;
        Transaction transaction = null;

        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            NativeQuery<Patient> query = session.createNativeQuery("CALL GetPagedPatients(:page, :pageSize)", Patient.class);
            query.setParameter("page", page);
            query.setParameter("pageSize", pageSize);

            patients = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return patients;
    }
}

