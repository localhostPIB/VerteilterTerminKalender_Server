package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventParticipate;

import java.util.List;

/**
 * Interface for the EventParticipateDAO
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public interface EventParticipateDAO
{
    // ------------- ADD -------------
    int addEventParticipate(EventParticipate eventParticipate);

    // ------------- GET 1 -------------
    EventParticipate getEventParticipate(int userId);

    // ------------- GET ALL -------------
    List<Integer> getUserWhoAccept(int eventId);

    // ------------- GET ALL -------------
    List<EventParticipate> getAllParticipate(int userId);

    // ------------- DELETE 1 -------------
    void deleteEventParticipate(int participateId);

    // ------------- DELETE ALL -------------
    void removeAllEventParticipate();
}
