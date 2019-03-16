package terminkalender.service.interfaces;

import terminkalender.model.interfaces.EventParticipate;

/**
 * Interface for the EventParticipateService
 */
public interface EventParticipateService
{
    // ------------- POST -------------
    EventParticipate addParticipation(EventParticipate eventParticipate);

    // ------------- GET -------------
    EventParticipate getParticipation(int participateId);

    // ------------- GET ALL USER WHO ACCEPT------------------------------
    String getUserWhoAccept(int eventId);

    // ------------- DELETE -------------
    void deleteParticipation(int participateId);
}
