package com.fpt.fsa.dao;

import com.fpt.fsa.entity.Bill;
import com.fpt.fsa.untils.HibernateUntils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class BillDAO extends GenericDAO<Bill, Long> {
    public BillDAO() {
        super(Bill.class);
    }

    public List<Bill> findByBillDate(Date billDate) {
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Bill b WHERE b.date = :billDate", Bill.class)
                    .setParameter("billDate", billDate)
                    .list();
        }
    }

    public List<Bill> getPagedBills(int offset, int limit) {
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Bill> criteriaQuery = criteriaBuilder.createQuery(Bill.class);
            Root<Bill> root = criteriaQuery.from(Bill.class);
            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        }
    }
}

