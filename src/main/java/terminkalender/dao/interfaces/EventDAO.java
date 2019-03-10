package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.Event;

import java.util.List;

public interface EventDAO extends ObjectDAO{
    int addEvent(Event event);
    Event getEvent(int eventId);
    void updateEvent(Event event);
    void deleteEvent(int eventId);
    List<Event> getAllEventFromUser(int userId);

    void removeAllEventData();
}
