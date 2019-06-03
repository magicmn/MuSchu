package de.muSchus.gso.database.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RolleConverter implements AttributeConverter<Rolle, String> {

    @Override
    public String convertToDatabaseColumn(Rolle attribute) {
        return attribute != null ? attribute.name() : null;
    }

    @Override
    public Rolle convertToEntityAttribute(String dbData) {
        try {
            return Rolle.valueOf(dbData);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
