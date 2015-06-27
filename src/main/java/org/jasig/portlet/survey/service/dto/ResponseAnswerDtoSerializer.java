package org.jasig.portlet.survey.service.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Custom serializer for {@link ResponseAnswerDTO}.
 *
 * @since 1.1
 */
public final class ResponseAnswerDtoSerializer extends JsonSerializer<ResponseAnswerDTO> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void serialize(ResponseAnswerDTO value, JsonGenerator generator, SerializerProvider provider)
    throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeNumberField("question", value.getQuestion());
        if (value.isMultiple()) {
            generator.writeFieldName("answer");
            generator.writeStartObject();
            for (Long answer : value.getAnswer()) {
                generator.writeBooleanField(String.valueOf(answer), true);
            }
            generator.writeEndObject();
        } else {
            generator.writeNumberField("answer", value.getAnswer().iterator().next());
        }
        generator.writeEndObject();
    }
}
