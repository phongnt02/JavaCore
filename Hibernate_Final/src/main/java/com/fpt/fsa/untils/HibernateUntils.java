package com.fpt.fsa.untils;

import com.fpt.fsa.fa.training.entities.*;
import com.fpt.fsa.fa.training.entities.Computer;
import com.fpt.fsa.fa.training.entities.Manufacturer;
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
            cfg.addAnnotatedClass(Computer.class);
            cfg.addAnnotatedClass(Manufacturer.class);

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
