package org.codehaven.userapi.service.impl;

import org.codehaven.userapi.dao.UserDao;
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

import java.util.List;

/**
 * Created by amjad on 7/23/15.
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("UserDao")
    private UserDao userDao;

    @Autowired
    private DtoTransformer transformer;

    private static final Logger logger = LoggerFactory.getLogger(DtoTransformer.class);

    @Override
    public List<UserDto> getUserDtoList(Long id) {

        List<User> users = userDao.getUserList(id);
        logger.debug("--- users " + users);
        return transformer.getUserDtoList(users);
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = transformer.getUser(userDto);
        userDao.createUser(user);
        return  transformer.getUserDto(user);
    }

    @Override
    public void modifyUser(Long userId, UserDto userDto) {

        List<User> users = userDao.getUserList(userId);
        if(users != null && !users.isEmpty()) {
            User exUser = users.get(0);
            exUser.update(userDto);
            userDao.modifyUser(exUser);
        }
    }

    @Override
    public int deleteUser(Long userId) {
        return userDao.deleteUser(userId);
    }
}