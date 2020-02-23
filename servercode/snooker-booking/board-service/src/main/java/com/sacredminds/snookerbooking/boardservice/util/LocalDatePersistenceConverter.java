package com.sacredminds.snookerbooking.boardservice.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.persistence.AttributeConverter;

public class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {
	
	@Override
	public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {

		return java.sql.Date.valueOf(entityValue);
	}

	@Override
	public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {

		return databaseValue.toLocalDate();
	}
	
	public LocalDate convertToLocalDate(java.util.Date dateToConvert) {

		return LocalDate.ofInstant(
			      dateToConvert.toInstant(), ZoneId.systemDefault());
	}

}