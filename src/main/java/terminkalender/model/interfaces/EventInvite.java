package terminkalender.model.interfaces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import terminkalender.model.classes.EventInviteImpl;

/**
 * Interface for model class EventInvite
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@JsonDeserialize(as = EventInviteImpl.class)
public interface EventInvite
{
	//----------------INVITEID----------------
	public int getInviteId();
	public void setInviteId(int inviteId);

	//----------------USERID----------------
	public int getUserId();
	public void setUserId(int userId);

	//----------------EVENTID----------------
	public int getEventId();
	public void setEventId(int eventId);
}
