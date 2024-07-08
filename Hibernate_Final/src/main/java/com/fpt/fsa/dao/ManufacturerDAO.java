package com.fpt.fsa.dao;

import com.fpt.fsa.fa.training.entities.Manufacturer;
import com.fpt.fsa.fa.training.entities.Computer;
import com.fpt.fsa.untils.HibernateUntils;
import org.hibernate.Session;
import java.util.List;

public class ManufacturerDAO extends GenericDAO<Manufacturer, Integer> {
    public ManufacturerDAO() {
        super(Manufacturer.class);
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findAllDetail() {
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT m.shortName, m.fullName, c FROM Manufacturer m LEFT JOIN m.listComputers c"
            ).list();
        }
    }
    @Override
    protected void validateEntity(Manufacturer entity) {
        System.out.println("validate Manufacturer done");
    }
}
