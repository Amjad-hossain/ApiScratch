package org.codehaven.userapi.service.impl;

import org.codehaven.userapi.dao.Dao;
import org.codehaven.userapi.dto.DtoTransformer;
import org.codehaven.userapi.dto.UserDto;
import org.codehaven.userapi.model.User;
import org.codehaven.userapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by amjad on 7/23/15.
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("Dao")
    private Dao dao;

    @Autowired
    private DtoTransformer transformer;

    private static final Logger logger = LoggerFactory.getLogger(DtoTransformer.class);

    @Override
    public List<UserDto> getUserDtoList(Long id) {

        TypedQuery<User> query= dao.createQuery(("FROM User u" + ((id != null && id > 0 )?  " WHERE u.id = :userId" : "")), User.class);
        if(id != null && id > 0) {
            query.setParameter("userId", id);
        }
        return transformer.getUserDtoList(query.getResultList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = transformer.getUser(userDto);
        dao.persist(user);
        return transformer.getUserDto(user);
    }

    @Override
    public void modifyUser(Long userId, UserDto userDto) {

        User user = dao.findById(User.class, userId);
        if(user != null ) {
            user.update(userDto);
            dao.merge(user);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        Query query = dao.createNamedQuery("User.deleteById").setParameter("userId", userId);
        query.executeUpdate();
    }
}