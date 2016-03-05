package org.codehaven.userapi.util;

import org.codehaven.userapi.filters.ResponseCorsFilter;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.TracingConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Created by amjad on 7/3/15.
 */
public class JerseyAppSetup extends ResourceConfig {

    public JerseyAppSetup() {

        packages("org.codehaven");
        register(ResponseCorsFilter.class);
        register(LoggingFilter.class);
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        property(ServerProperties.TRACING, TracingConfig.ALL.name());
    }
}
