package com.venkat.consumer.deser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venkat.consumer.dto.EmployeeDto;
import org.apache.kafka.common.serialization.Deserializer;
import java.io.IOException;
import java.util.Map;

public class EmployeeDeserializer implements Deserializer<EmployeeDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public EmployeeDto deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, EmployeeDto.class);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing object", e);
        }
    }

    @Override
    public void close() {
    }
}
