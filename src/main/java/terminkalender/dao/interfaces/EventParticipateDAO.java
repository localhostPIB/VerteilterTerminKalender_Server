package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventParticipate;

public interface EventParticipateDAO {
    int addEventParticipate(EventParticipate eventParticipate);
    void deleteEventParticipate(int participateId);
    EventParticipate getEventParticipate(int userId);

    void removeAllEventParticipate();
}
