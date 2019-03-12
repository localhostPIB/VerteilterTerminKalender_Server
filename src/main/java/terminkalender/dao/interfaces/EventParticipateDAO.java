package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventParticipate;

/**
 * Interface for the EventParticipateDAO
 */
public interface EventParticipateDAO
{
    // ------------- ADD -------------
    int addEventParticipate(EventParticipate eventParticipate);

    // ------------- GET 1 -------------
    EventParticipate getEventParticipate(int userId);

    // ------------- DELETE 1 -------------
    void deleteEventParticipate(int participateId);

    // ------------- DELETE ALL -------------
    void removeAllEventParticipate();
}
