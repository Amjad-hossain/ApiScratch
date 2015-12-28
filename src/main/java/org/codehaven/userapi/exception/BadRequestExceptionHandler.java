package org.codehaven.userapi.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by amjad on 8/4/15.
 */

@Provider
public class BadRequestExceptionHandler implements ExceptionMapper<BadRequestException> {

    private static final Logger logger = LoggerFactory.getLogger(BadRequestExceptionHandler.class);
    @Override
    public Response toResponse(BadRequestException e) {
        logger.error("--- Bad request exception:: " + e.getMessage());
        e.printStackTrace();
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(new ErrorMessage(e)).build();
    }
}
