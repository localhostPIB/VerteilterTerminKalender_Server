package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.EventParticipate;

public interface EventParticipateService
{
	public EventParticipate addParticipated(EventParticipate eventParticipate);
	//public ResponseEntity<?> deleteParticipated(long eventId, int participatedUserId);
	public ResponseEntity<?> deleteParticipated(long eventId);
}
