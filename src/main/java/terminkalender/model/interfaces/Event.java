package terminkalender.model.interfaces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import terminkalender.model.classes.EventImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Interface for model class Event
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@JsonDeserialize(as = EventImpl.class)
public interface Event
{
	//----------------EVENTID----------------
	public int getEventId();
	public void setEventId(int eventId);

	//----------------LOCATION----------------
	public String getLocation();
	public void setLocation(String location);

	//----------------STARTTIME----------------
	public LocalDateTime getStartTime();
	public void setStartTime(LocalDateTime startTime);

	//----------------ENDTIME----------------
	public LocalDateTime getEndTime();
	public void setEndTime(LocalDateTime endTime);

	//----------------DURATION----------------
	public Duration getDuration();

	//----------------ALLDAY----------------
	public boolean isAllDay();
	public void setAllDay(boolean allDay);

	//----------------REPEAT----------------
	public int getRepeat();
	public void setRepeat(int repeat);

	//----------------NOTES----------------
	public String getNote();
	public void setNote(String note);

	//----------------USERID----------------
	public int getUserId();
	public void setUserId(int userId);
}
