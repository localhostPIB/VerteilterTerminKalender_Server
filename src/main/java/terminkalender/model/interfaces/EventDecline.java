package terminkalender.model.interfaces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import terminkalender.model.classes.EventDeclineImpl;
import terminkalender.model.classes.EventInviteImpl;

/**
 * Interface for model class EventDecline
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@JsonDeserialize(as = EventDeclineImpl.class)
public interface EventDecline
{

    //----------------DECLINEDID----------------
    public int getDeclineId();
    public void setDeclineId(int declineId);

    //----------------USERID----------------
    public int getUserId();
    public void setUserId(int userId);

    //----------------EVENTID----------------
    public int getEventId();
    public void setEventId(int eventId);
}
