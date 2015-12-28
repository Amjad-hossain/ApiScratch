package org.codehaven.userapi.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.BeanUtils;

/**
 * Created by amjad on 8/6/15.
 */
public class ErrorMessage {

    @JsonProperty("error-code")
    private int code;

    @JsonProperty("status")
    private int httpStatusCode;

    private String message;

    @JsonProperty("help")
    private String helpLink;

    public ErrorMessage(BadRequestException badRequestException) {
        BeanUtils.copyProperties(badRequestException, this);
    }

    public ErrorMessage(int code, int httpStatusCode, String message, String helpLink) {
        this.code = code;
        this.httpStatusCode = httpStatusCode;
        this.message = message;
        this.helpLink = helpLink;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHelpLink() {
        return helpLink;
    }

    public void setHelpLink(String helpLink) {
        this.helpLink = helpLink;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
