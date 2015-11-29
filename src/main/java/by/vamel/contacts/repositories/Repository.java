package by.vamel.contacts.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Repository<E> {
    private final EntityManager entityManager = Persistence
            .createEntityManagerFactory("training").createEntityManager();
    private final Class<E> entityClass;

    public Repository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public E save(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entity = entityManager.merge(entity);
        transaction.commit();
        return entity;
    }

    public void delete(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
    }

    public E find(long id) {
        return entityManager.find(entityClass, id);
    }

    public List<E> findAll() {
        Query query = entityManager
                .createQuery("from " + entityClass.getSimpleName(), entityClass);
        return query.getResultList();
    }
}
