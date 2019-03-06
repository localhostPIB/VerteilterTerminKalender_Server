package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.EventDecline;

public interface EventDeclineService {
    public EventDecline addDecline(EventDecline eventDecline);
    public ResponseEntity<?> deleteDecline(long declinedUserId);
}
