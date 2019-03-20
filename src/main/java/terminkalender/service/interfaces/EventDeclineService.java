package terminkalender.service.interfaces;

import terminkalender.model.interfaces.EventDecline;

/**
 * Interface for the EventDeclineService
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public interface EventDeclineService
{
    // ------------- POST -------------
    EventDecline addDecline(EventDecline eventDecline);

    // ------------- GET -------------
    EventDecline getDecline(int declineId);

    // ------------- GET ALL USER WHO DECLINE ------------------------------
    String getUserWhoDecline(int eventId);

    // ------------- DELETE -------------
    void deleteDecline(int declineId);
}
