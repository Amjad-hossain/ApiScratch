package org.codehaven.userapi.dao.impl;

import org.codehaven.userapi.dao.UserDao;
import org.codehaven.userapi.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by amjad on 7/23/15.
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManager") private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private void saveObject(Object object) {

        this.entityManager.persist(object);
    }

    private void updateObject(Object object) {

        this.entityManager.merge(object);
    }

    private Object readObject(Class clz ,Long id) {
        return  this.entityManager.find(clz, id);
    }

    private void deleteObject(Object object) {
        this.entityManager.remove(object);
    }

    @Override
    public List<User> getUserList(Long id) {

        String sql = "FROM User u" + ((id != null && id > 0 )?  " WHERE u.id = :userId" : "");
        TypedQuery<User> query = this.entityManager.createQuery(sql, User.class);
        if(id != null && id > 0) {
            query.setParameter("userId", id);
        }
        return query.getResultList();
    }

    @Override
    public void createUser(User user) {
        user.setId(null);
        saveObject(user);
    }

    @Override
    public void modifyUser(User user) {
        updateObject(user);
    }

    @Override
    public int deleteUser(Long userId) {

        Query query = this.entityManager.createNamedQuery("User.deleteById").setParameter("userId", userId);
        return  query.executeUpdate();
    }
}