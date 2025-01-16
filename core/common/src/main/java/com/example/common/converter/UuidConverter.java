package com.example.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

import static java.util.Objects.isNull;

@Converter
public class UuidConverter implements AttributeConverter<String, UUID> {
    @Override
    public UUID convertToDatabaseColumn(String attribute) {
        return isNull(attribute)
                ? null
                : UUID.fromString(attribute);
    }

    @Override
    public String convertToEntityAttribute(UUID uuid) {
        return isNull(uuid)
                ? null
                : uuid.toString();
    }
}
