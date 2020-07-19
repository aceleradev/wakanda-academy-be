package com.aceleradev.api.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

public class DateUtils {
	
	public static Date toDate(LocalDateTime date) {
		return Optional.ofNullable(date)
					   .map(d -> d.atZone(ZoneId.systemDefault()))
					   .map(ZonedDateTime::toInstant)
					   .map(Date::from)
					   .orElse(null);
	}
	
	public static LocalDateTime toLocalDateTime(Date date) {
		return Optional.ofNullable(date)
					.map(Date::toInstant)
					.map(instant -> instant.atZone(ZoneId.systemDefault()))
					.map(ZonedDateTime::toLocalDateTime)
					.orElse(null);
	}
	
}
