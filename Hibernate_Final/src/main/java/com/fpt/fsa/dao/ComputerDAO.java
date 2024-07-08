package com.fpt.fsa.dao;

import com.fpt.fsa.fa.training.entities.Computer;
import com.fpt.fsa.untils.HibernateUntils;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class ComputerDAO extends GenericDAO<Computer, Integer> {
    public ComputerDAO() {
        super(Computer.class);
    }

    @SuppressWarnings("unchecked")
    public List<Computer> findByManufacturerName(String manufactureFullName, Integer status) {
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            if (status == null) {
                return session.createQuery(
                                "SELECT c FROM Computer c JOIN c.doctor m WHERE m.fullName = :fullName"
                        )
                        .setParameter("fullName", manufactureFullName)
                        .list();
            } else {
                return session.createQuery(
                                "SELECT c FROM Computer c JOIN c.doctor m WHERE m.fullName = :fullName AND c.produceStatus = :status"
                        )
                        .setParameter("fullName", manufactureFullName)
                        .setParameter("status", status)
                        .list();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Computer> findByStatus(Integer status, Date date) {
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            return session.createQuery(
                            "SELECT c FROM Computer c WHERE c.produceStatus = :status AND c.registrationDate <= :date"
                    )
                    .setParameter("status", status)
                    .setParameter("date", date)
                    .list();
        }
    }

    @Override
    protected void validateEntity(Computer entity) {
        if (entity.getRegistrationDate() != null && entity.getRegistrationDate().before(new Date())) {
            throw new IllegalArgumentException("Registration date must be in the present or in the future");
        }
        if (entity.getPrice() < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to 0");
        }
        if (entity.getProduceStatus() != 0 && entity.getProduceStatus() != 1) {
            throw new IllegalArgumentException("Produce status must be 0 or 1");
        }
    }
}
