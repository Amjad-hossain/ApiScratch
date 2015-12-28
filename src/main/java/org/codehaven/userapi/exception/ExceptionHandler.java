package org.codehaven.userapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by amjad on 8/6/15.
 */

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public Response toResponse(Exception e) {
        logger.error("--- Internal server error:: " + e.getMessage());
        e.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(new ErrorMessage(696969, 500, e.getMessage(), "www.codehaven.com")).build();
    }
}
