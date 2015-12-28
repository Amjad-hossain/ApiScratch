package org.codehaven.userapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by amjad on 7/3/15.
 */
public class Utils {


    public static String objectToJson(Object object) throws Exception{

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(object);
    }

    public static final Map jsonStringToMap(String jsonString) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(jsonString, Map.class);
        return map;
    }

    public static boolean isEmpty(List list) {
        if(list == null ) {

            return true;
        }
        if(list.size() == 0) {

            return true;
        }

        return false;
    }


}