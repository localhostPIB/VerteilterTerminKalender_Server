package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.Event;

import java.util.List;

public interface EventService
{
	public Event addEvent(Event event);
	public ResponseEntity<Event> getEvent(long eventId);
	public ResponseEntity<Event> updateEvent(long eventId, Event event);
	public ResponseEntity<?> deleteEvent(long eventId);

	public List<Event> getAllEventFromUser(int userId);


}
