package com.github.thientoan3596.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.validation.FieldError;

import java.io.IOException;

@SuppressWarnings("ALL")
public class FieldErrorDeserializer extends JsonDeserializer<FieldError> {
    @Override
    public FieldError deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String objectName = node.has("objectName") ? node.get("objectName").asText() : "";
        String field = node.get("field").asText();
        Object rejectedValue = node.has("rejectedValue") ? node.get("rejectedValue").asText() : null;
        String message = node.get("defaultMessage").asText();
        return new FieldError(objectName, field, rejectedValue, false, null, null, message);
    }
}
