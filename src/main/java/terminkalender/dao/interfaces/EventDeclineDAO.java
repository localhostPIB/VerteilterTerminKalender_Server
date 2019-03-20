package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventDecline;

import java.util.List;

/**
 * Interface for the EventDeclineDAO
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public interface EventDeclineDAO extends ObjectDAO
{
    // ------------- ADD -------------
    int addEventDecline(EventDecline eventDecline);

    // ------------- GET 1 -------------
    EventDecline getEventDecline(int userId);

     // ------------- GET ALL -------------
    List<Integer> getUserWhoDecline(int eventId);

    // ------------- DELETE 1 -------------
    void deleteEventDecline(int declineId);

    // ------------- DELETE ALL -------------
    void removeAllEventDecline();
}
