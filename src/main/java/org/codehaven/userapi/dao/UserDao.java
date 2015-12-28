package org.codehaven.userapi.dao;

import org.codehaven.userapi.dto.UserDto;
import org.codehaven.userapi.model.User;

import java.util.List;

/**
 * Created by amjad on 7/23/15.
 */
public interface UserDao {

    List<User> getUserList(Long id);

    void createUser(User user);

    void modifyUser(User user);

    int deleteUser(Long userId);

}