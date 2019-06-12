package de.muSchus.gso.database.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
            return attribute != null ? Date.valueOf(attribute) : null;
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        return dbData != null ? dbData.toLocalDate() : null;
    }
}
