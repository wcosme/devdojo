package academy.devdojo.springboot2.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	
	static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

	public static String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(localDateTime);
	}

	public static LocalDateTime formatStringToLocalDateTime(String data) {
		LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
		return dateTime;
	}

}
