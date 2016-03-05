package org.codehaven.userapi.dao.impl;


import org.codehaven.userapi.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by coder on 1/23/16.
 */
@Repository("Dao")
public class DaoImpl implements Dao {

    private static final Logger logger = LoggerFactory.getLogger(DaoImpl.class);

    @PersistenceContext private EntityManager entityManager;

    @Override
    public <T> T findById(Class<T> kClass, Object key) {

        return this.entityManager.find(kClass, key);
    }

    @Override
    public <T> List<T> findAll(String jpaString, Class<T> resultClass) {

        return this.entityManager.createQuery(jpaString, resultClass).getResultList();
    }

    @Override
    public void persist(Object entity) {

        this.entityManager.persist(entity);
    }

    @Override
    public  <T> T merge(T entity) {

        return this.entityManager.merge(entity);
    }

    @Override
    public <T> TypedQuery<T> createQuery(String jpaString, Class<T> tClass) {
        return this.entityManager.createQuery(jpaString, tClass);
    }

    @Override
    public void remove(Object object) {
        this.entityManager.remove(object);
    }

    @Override
    public Query createNamedQuery(String jpaString) {
        return this.entityManager.createNamedQuery(jpaString);
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(String jpaString, Class<T> tClass) {
        return this.entityManager.createNamedQuery(jpaString, tClass);
    }
}
