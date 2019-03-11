package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.EventParticipate;

public interface EventParticipateService
{
    public EventParticipate addParticipation(EventParticipate eventParticipate);
    public EventParticipate getParticipation(int userId);
    public void deleteParticipation(int participateId);

}
