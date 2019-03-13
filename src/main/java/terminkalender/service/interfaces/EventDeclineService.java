package terminkalender.service.interfaces;

import terminkalender.model.interfaces.EventDecline;

/**
 * Interface for the EventDeclineService
 */
public interface EventDeclineService
{
    // ------------- POST -------------
    EventDecline addDecline(EventDecline eventDecline);

    // ------------- GET -------------
    EventDecline getDecline(int declineId);

    // ------------- DELETE -------------
    void deleteDecline(int declineId);
}
