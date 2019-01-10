package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.Event;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@Getter @Setter
public class EventImpl implements Event
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventid", nullable = false, unique = true)
	private int eventId;

	@Column(name = "location")
	private String location;

	@Column(name = "starttime")
	private LocalDateTime startTime;

	@Column(name = "endtime")
	private LocalDateTime endTime;

	@Column(name = "allday")
	@Convert(converter = BooleanToIntegerConverter.class)
	private boolean allDay;

	@Column(name = "repeat")
	private int repeat;

	@Column(name = "note")
	private String note;

	@Column(name = "userid")
	private int userId;

	@Override
	public Duration getDuration() {
		return Duration.between(startTime, endTime);
	}
}

/**
 * this class will provide method for convert boolean attribute allDay from the EventImpl class
 * to type integer to be stored in the database (1 == event is all day, 0 == not all day)
 */
class BooleanToIntegerConverter implements AttributeConverter<Boolean, Integer> {

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
