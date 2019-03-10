package terminkalender.service.interfaces;

import terminkalender.model.interfaces.Event;

import java.util.List;

public interface EventService
{
	public Event addEvent(Event event);
	public Event getEvent(int eventId);
	public void updateEvent(Event event);
	public void deleteEvent(int eventId);
	public String getAllEventFromUser(int userId);
}
