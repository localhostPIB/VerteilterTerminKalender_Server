package terminkalender.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;

@Converter
public class LocalDateTimeToStringConverter implements AttributeConverter<LocalDateTime, String>
{
	@Override
	public String convertToDatabaseColumn(LocalDateTime localDateTime) {
		return util.convertTimeToString(localDateTime);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(String time) {
		return util.convertStringToTime(time);
	}
}
