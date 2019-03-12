package terminkalender.service.interfaces;

import terminkalender.model.interfaces.Event;

/**
 * Interface for the EventService
 */
public interface EventService
{
	// ------------- POST -------------
	Event addEvent(Event event);

	// ------------- GET -------------
	Event getEvent(int eventId);

	// ------------- GET -------------
	String getAllEventFromUser(int userId);

	// ------------- GET -------------
	String getEventListFromUser(int userId, String startDate, String endDate);

	// ------------- PUT -------------
	void updateEvent(Event event);

	// ------------- DELETE -------------
	void deleteEvent(int eventId);
}
