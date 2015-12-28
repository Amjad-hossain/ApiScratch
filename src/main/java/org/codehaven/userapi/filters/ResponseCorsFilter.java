package org.codehaven.userapi.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * Created by amjad on 7/3/15.
 */
public class ResponseCorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext contResp) {

        contResp.getHeaders().add("Access-Control-Allow-Origin","*");
        contResp.getHeaders().add("Access-Control-Allow-Methods", "*, Cache-Control, Pragma, Origin, Authorization, X-Requested-With, PUT, DELETE");
        contResp.getHeaders().add("Access-Control-Allow-Headers", "*, Content-Type, GET, OPTIONS, X-XSRF-TOKEN, X-Redmine-API-Key");
    }
}
