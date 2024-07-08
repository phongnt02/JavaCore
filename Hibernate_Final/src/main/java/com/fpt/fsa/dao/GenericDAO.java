package com.fpt.fsa.dao;

import com.fpt.fsa.untils.HibernateUntils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class GenericDAO<T, ID> {
    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract void validateEntity(T entity);

    public void create(T entity) {
        // call validate the entity before saving
        validateEntity(entity);
        Transaction transaction = null;
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public T find(ID id) {
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            return session.get(entityClass, (java.io.Serializable) id);
        }
    }

    public void update(T entity) {
        // call validate the entity before saving
        validateEntity(entity);
        Transaction transaction = null;
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(ID id) {
        Transaction transaction = null;
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T entity = session.get(entityClass, (java.io.Serializable) id);
            if (entity != null) {
                session.delete(entity);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<T> findAll() {
        try (Session session = HibernateUntils.getSessionFactory().openSession()) {
            return session.createQuery("FROM " + entityClass.getName(), entityClass).list();
        }
    }
}
