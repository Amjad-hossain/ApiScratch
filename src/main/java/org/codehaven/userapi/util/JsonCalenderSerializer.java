package org.codehaven.userapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by amjad on 7/3/15.
 */
public class JsonCalenderSerializer extends JsonSerializer<Calendar> {

    @Override
    public void serialize(Calendar calendar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        jsonGenerator.writeString(formatter.format(calendar.getTime()));
    }
}

