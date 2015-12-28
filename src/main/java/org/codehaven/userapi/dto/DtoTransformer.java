package org.codehaven.userapi.dto;

import org.codehaven.userapi.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amjad on 8/14/15.
 */
@Component
public class DtoTransformer {

    private static final Logger logger = LoggerFactory.getLogger(DtoTransformer.class);

    public User getUser(UserDto userDto) {

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public UserDto getUserDto(User user) {

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public List<UserDto> getUserDtoList(List<User> users) {

        List<UserDto> userDtoList = new ArrayList<UserDto>();
        for( User user: users) {
            userDtoList.add(getUserDto(user));
        }
        return userDtoList;
    }
}
