package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventDecline;

public interface EventDeclineDAO extends ObjectDAO{
    int  addEventDecline(EventDecline eventDecline);
    void deleteEventDecline(int declineId);
    EventDecline getEventDecline(int userId);

    void removeAllEventDecline();
}
