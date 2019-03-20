package terminkalender.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * this class will provide method for convert boolean attribute allDay from the EventImpl class
 * to type integer to be stored in the database (1 == event is all day, 0 == not all day)
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@Converter
public class BooleanToIntegerConverter implements AttributeConverter<Boolean, Integer> {

	//if allDay is true store 1 in the database, else 0
	@Override
	public Integer convertToDatabaseColumn(Boolean allDay) {
		return allDay ? 1 : 0;
	}

	//if allDayInt == 0, return false else true
	@Override
	public Boolean convertToEntityAttribute(Integer allDayInt) {
		return allDayInt != 0;
	}

}
