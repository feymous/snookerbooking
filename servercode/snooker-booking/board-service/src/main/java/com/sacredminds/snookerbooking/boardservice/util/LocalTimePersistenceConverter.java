package com.sacredminds.snookerbooking.boardservice.util;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;

//@Converter(autoApply = true)
public class LocalTimePersistenceConverter implements
    AttributeConverter<LocalTime, Time> {
    @Override
    public java.sql.Time convertToDatabaseColumn(LocalTime entityValue) {
    	
        return java.sql.Time.valueOf(entityValue);
    }

    @Override
    public LocalTime convertToEntityAttribute(java.sql.Time databaseValue) {
    	
        return databaseValue.toLocalTime();
    }


}