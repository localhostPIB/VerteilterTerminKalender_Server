package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.Event;

import java.util.List;

public interface EventDAO extends ObjectDAO{
    public int addEvent(Event event);
    public Event getEvent(int eventId);
    public void updateEvent(Event event);
    public void deleteEvent(int eventId);

    public List<Event> getAllEventFromUser(int userId);
}
