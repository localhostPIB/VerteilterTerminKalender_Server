package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.EventDecline;

public interface EventDeclineService {
    EventDecline addDecline(EventDecline eventDecline);
    EventDecline getDecline(int userId);
    void deleteDecline(int declineId);
}
