package terminkalender.model.interfaces;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import terminkalender.model.classes.EventDeclineImpl;
import terminkalender.model.classes.EventInviteImpl;

@JsonDeserialize(as = EventDeclineImpl.class)
public interface EventDecline {

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
