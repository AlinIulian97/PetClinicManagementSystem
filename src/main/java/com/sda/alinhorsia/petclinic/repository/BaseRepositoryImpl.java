package com.sda.alinhorsia.petclinic.repository;

import com.sda.alinhorsia.petclinic.model.Vet;
import com.sda.alinhorsia.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<T> implements BaseRepository<T> {
    private final Class<T> entityClass;

    public BaseRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> getAll() {

        try (Session session = SessionManager.getSessionFactory().openSession()) {
            List<T> allEntities = session.createQuery(
                    "FROM " + entityClass.getSimpleName(),
                    entityClass
            ).getResultList();
            return allEntities;
        }
    }

    @Override
    public Optional<T> findById(int id) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            T entity = session.find(entityClass, id);
            return Optional.ofNullable(entity);
        }
    }

    @Override
    public void create(T entity) {
        Transaction transaction = null;
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateBYid(int id, T entity) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {

            T entityFromDB = session.find(entityClass, id);
            if (entityFromDB != null) {
                Transaction transaction = session.beginTransaction();
                try {
                    session.saveOrUpdate(entity);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw new IllegalStateException(e);
                }

            } else {
                throw new IllegalStateException(entityClass.getSimpleName()
                        + " Id not found in database");
            }
        }
    }

    @Override
    public void deleteById(int id) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            T entity = session.find(entityClass, id);
            if (entity != null) {
                Transaction transaction = session.beginTransaction();
                try {
                    session.delete(entity);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw new IllegalStateException(e);
                }
            } else {
                throw new IllegalArgumentException(
                        entityClass.getSimpleName() + " ID IS NOT FOUND IN DATABASE"
                );
            }
        }
    }
}

