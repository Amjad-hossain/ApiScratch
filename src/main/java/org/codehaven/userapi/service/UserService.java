package org.codehaven.userapi.service;

import org.codehaven.userapi.dto.UserDto;

import java.util.List;

/**
 * Created by amjad on 7/23/15.
 */
public interface UserService {

    List<UserDto> getUserDtoList( Long id);

    UserDto createUser(UserDto userDto);

    void modifyUser(Long userId,  UserDto userDto);

    void deleteUser(Long userId);
}