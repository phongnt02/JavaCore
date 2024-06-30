package com.fpt.fsa.dao;
import com.fpt.fsa.entity.Payment;
import com.fpt.fsa.untils.HibernateUntils;
import org.hibernate.Session;
import java.util.List;

public class PaymentDAO extends GenericDAO<Payment, Long> {
    public PaymentDAO() {
        super(Payment.class);
    }

    public List<Payment> findByBill(Long billNumber) {
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Payment p WHERE p.bill.billNumber = :billNumber", Payment.class)
                    .setParameter("billNumber", billNumber)
                    .list();
        }
    }
}
