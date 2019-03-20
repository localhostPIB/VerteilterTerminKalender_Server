package terminkalender.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;

/**
 * this will be used for JSONSerializer / JSONDeserializer to convert between types
 * so it will be able to be stored in the database or the other way around
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@Converter
public class LocalDateTimeToStringConverter implements AttributeConverter<LocalDateTime, String>
{
	/**
	 * convert LocalDateTime to String representing the time
	 * format example: 2019-03-16T13:42:00
	 */
	@Override
	public String convertToDatabaseColumn(LocalDateTime localDateTime) {
		return util.convertTimeToString(localDateTime);
	}

	/**
	 * convert string representing the time in the database to LocalDateTime Object
	 * format example: 2019-03-16T13:42:00
	 */
	@Override
	public LocalDateTime convertToEntityAttribute(String time) {
		return util.convertStringToTime(time);
	}
}
