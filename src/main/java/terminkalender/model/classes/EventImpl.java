package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.Event;
import terminkalender.util.BooleanToIntegerConverter;
import terminkalender.util.LocalDateTimeToStringConverter;

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
	@Convert(converter = LocalDateTimeToStringConverter.class)
	private LocalDateTime startTime;

	@Column(name = "endtime")
	@Convert(converter = LocalDateTimeToStringConverter.class)
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
