package org.codehaven.userapi.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wordnik.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;
import org.codehaven.userapi.dto.UserDto;
import org.codehaven.userapi.listener.UserListener;
import org.codehaven.userapi.util.JsonDateDeserializer;
import org.codehaven.userapi.util.JsonDateSerializer;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by amjad on 7/3/15.
 */

@Entity
@EntityListeners({UserListener.class})
@Table(name = "USR")
@NamedQueries( {
    @NamedQuery(name = "User.deleteById", query = "DELETE FROM User u WHERE u.id = :userId")
})
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    private String userName;

    private String displayName;

    private String timeZone;

    private boolean active;

    private Date createdOn;

    private Date modifiedOn;

    private String language;

    private String email;

    private String contactNo;

    public void update(UserDto userDto) {

        this.setUserName(userDto.getUserName());
        this.setDisplayName(userDto.getDisplayName());
        this.setTimeZone(userDto.getTimeZone());
        this.setContactNo(userDto.getContactNo());
    }
}


