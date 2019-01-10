package terminkalender.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class util
{
	public static String convertTimeToString(LocalDateTime localDateTime) {
		return localDateTime.truncatedTo(ChronoUnit.MINUTES)
							 .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	public static LocalDateTime convertStringToTime(String time) {
		return LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
							 .truncatedTo(ChronoUnit.MINUTES);
	}
}
