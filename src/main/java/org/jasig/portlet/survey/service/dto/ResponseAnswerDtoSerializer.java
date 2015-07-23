/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
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
