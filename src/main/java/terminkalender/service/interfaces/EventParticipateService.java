package terminkalender.service.interfaces;

import terminkalender.model.interfaces.EventParticipate;

/**
 * Interface for the EventParticipateService
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public interface EventParticipateService
{
    // ------------- POST -------------
    EventParticipate addParticipation(EventParticipate eventParticipate);

    // ------------- GET -------------
    EventParticipate getParticipation(int participateId);

    // ------------- GET ALL USER WHO ACCEPT -------------
    String getUserWhoAccept(int eventId);

    // ------------- GET ALL PARTICIPATE -------------
    String getAllParticipate(int userId);

    // ------------- DELETE -------------
    void deleteParticipation(int participateId);
}
