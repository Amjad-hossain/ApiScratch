package org.codehaven.userapi.exception;

/**
 * Created by amjad on 7/3/15.
 */
public class BadRequestException extends ApiException{

    private int code;

    private int httpStatusCode;

    private String helpLink;

    public BadRequestException (int code, int httpStatusCode, String message, String helpLink) {
        super(httpStatusCode, message);
        this.code = code;
        this.httpStatusCode = httpStatusCode;
        this.helpLink = helpLink;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getHelpLink() {
        return helpLink;
    }

    public void setHelpLink(String helpLink) {
        this.helpLink = helpLink;
    }
}
