package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventDecline;

/**
 * Interface for the EventDeclineDAO
 */
public interface EventDeclineDAO extends ObjectDAO
{
    // ------------- ADD -------------
    int addEventDecline(EventDecline eventDecline);

    // ------------- GET 1 -------------
    EventDecline getEventDecline(int userId);

    // ------------- DELETE 1 -------------
    void deleteEventDecline(int declineId);

    // ------------- DELETE ALL -------------
    void removeAllEventDecline();
}
