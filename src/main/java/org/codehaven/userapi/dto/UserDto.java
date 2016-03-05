package org.codehaven.userapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.codehaven.userapi.util.JsonDateDeserializer;
import org.codehaven.userapi.util.JsonDateSerializer;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by coder on 12/24/15.
 */

@Data
public class UserDto {

    @JsonIgnore
    private Long id ;

    @ApiModelProperty(required = true)
    private String userName;

    @ApiModelProperty(required = true)
    private String displayName;

    @ApiModelProperty(required = true)
    private String timeZone;

    private boolean active;

    @JsonIgnore
    private Date createdOn;

    @JsonIgnore
    private Date modifiedOn;

    private String language;

    @ApiModelProperty(required = true)
    private String email;

    private String contactNo;

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty
    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getCreatedOn() {
        return createdOn;
    }

    @JsonIgnore
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty
    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getModifiedOn() {
        return modifiedOn;
    }

    @JsonIgnore
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
