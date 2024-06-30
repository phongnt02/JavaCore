package com.fpt.fsa.untils;

import com.fpt.fsa.entity.*;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUntils {
    @Getter
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            Configuration cfg = new Configuration().configure();
            // add annotated classes
            cfg.addAnnotatedClass(Doctor.class);
            cfg.addAnnotatedClass(Appointment.class);
            cfg.addAnnotatedClass(Bill.class);
            cfg.addAnnotatedClass(Payment.class);
            cfg.addAnnotatedClass(Patient.class);

            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(standardServiceRegistryBuilder.build());

            return sessionFactory;
        } catch (Throwable e) {
            System.out.println("Error while initializing hibernate configuration: " + e.getMessage());
        }
        return null;
    }
}
