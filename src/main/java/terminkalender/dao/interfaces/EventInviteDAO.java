package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventInvite;

import java.util.List;

/**
 * Interface for the EventInviteDAO
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public interface EventInviteDAO extends ObjectDAO
{
    // ------------- ADD -------------
    int addEventInvite(EventInvite eventInvite);

    // ------------- GET -------------
    EventInvite getEventInvite(int inviteId);

    // ------------- GET ALL -------------
    List<EventInvite> getAllInvitationToUser(int userId);

    // ------------- GET ALL -------------
    List<EventInvite> getLatestInviteToUser(int userId, int lastInviteIdQuery);

    // ------------- GET -------------
	int getLatestInviteIdToUser(int userId);

    // ------------- DELETE 1 -------------
    void deleteEventInvite(int inviteId);

    // ------------- DELETE ALL-------------
    void removeAllEventInvite();
}
