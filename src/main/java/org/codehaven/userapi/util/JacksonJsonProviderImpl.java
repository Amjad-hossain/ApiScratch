package org.codehaven.userapi.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;


import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * Created by amjad on 7/3/15.
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonJsonProviderImpl extends JacksonJaxbJsonProvider {

    private static ObjectMapper commonMapper = null;

    public JacksonJsonProviderImpl() {
        if(commonMapper == null){
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            commonMapper = mapper;
        }
        super.setMapper(commonMapper);
    }
}

