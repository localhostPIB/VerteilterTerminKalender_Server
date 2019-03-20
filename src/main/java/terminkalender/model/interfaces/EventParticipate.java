package terminkalender.model.interfaces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import terminkalender.model.classes.EventParticipateImpl;

/**
 * Interface for model class EventParticipate
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@JsonDeserialize(as = EventParticipateImpl.class)
public interface EventParticipate
{
	//----------------PARTICIPATEID----------------
	public int getParticipateId();
	public void setParticipateId(int participateId);

	//----------------USERID----------------
	public int getUserId();
	public void setUserId(int userId);

	//----------------EVENTID----------------
	public int getEventId();
	public void setEventId(int eventId);
}
