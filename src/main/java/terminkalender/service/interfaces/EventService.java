package terminkalender.service.interfaces;

import terminkalender.model.interfaces.Event;

import java.util.List;

public interface EventService
{
	public int addEvent(int eventId);
	public Event getEvent(int eventId);
	public void updateEvent(int eventId);
	public void deleteEvent(int eventId);

	public List<Event> getAllEventFromUser(int userId);


}
