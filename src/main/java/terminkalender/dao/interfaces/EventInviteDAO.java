package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventInvite;

import java.util.List;

/**
 * Interface for the EventInviteDAO
 */
public interface EventInviteDAO extends ObjectDAO
{
    // ------------- ADD -------------
    int addEventInvite(EventInvite eventInvite);

    // ------------- GET -------------
    EventInvite getEventInvite(int inviteId);

    // ------------- GET ALL -------------
    List<EventInvite> getAllInvitationToUser(int userId);

    List<EventInvite> getLatestInviteToUser(int userId, int lastInviteIdQuery);

	int getLatestInviteIdToUser(int userId);

    // ------------- DELETE 1 -------------
    void deleteEventInvite(int inviteId);

    // ------------- DELETE ALL-------------
    void removeAllEventInvite();
}
