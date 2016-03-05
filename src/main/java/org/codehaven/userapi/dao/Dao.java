package org.codehaven.userapi.dao;


import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by coder on 1/23/16.
 */
public interface Dao {

    <T> T findById(Class<T> kClass, Object key);

    <T> List<T> findAll(String jpaString, Class<T> resultClass);

    <T> TypedQuery<T> createQuery(String jpaString, Class<T> var2);

    void persist(Object entity);

    <T> T merge(T entity);

    void remove(Object var1);

    Query createNamedQuery(String jpaString);

    <T> TypedQuery<T> createNamedQuery(String jpaString, Class<T> tClass);
}
