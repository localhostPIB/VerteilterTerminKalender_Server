package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.Event;

import java.util.List;

/**
 * Interface for the EventDAO
 */
public interface EventDAO extends ObjectDAO
{
    // ------------- ADD -------------
    int addEvent(Event event);

    // ------------- GET 1 -------------
    Event getEvent(int eventId);

    // ------------- GET ALL -------------
    List<Event> getAllEventFromUser(int userId);

    // ------------- UPDATE -------------
    void updateEvent(Event event);

    // ------------- DELETE 1 -------------
    void deleteEvent(int eventId);

    // ------------- DELETE ALL -------------
    void removeAllEventData();
}
