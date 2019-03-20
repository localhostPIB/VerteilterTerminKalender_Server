package terminkalender.service.interfaces;

import terminkalender.model.interfaces.EventInvite;

import java.util.List;

/**
 * Interface for the EventInviteService
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public interface EventInviteService
{
	// ------------- POST -------------
	EventInvite addInvitation(EventInvite eventInvite);

	// ------------- GET -------------
	EventInvite getInvitation(int userId);

	// ------------- GET -------------
	String getInvitationToUser(int userId);


	List<EventInvite> getLatestInvitationsToUser(int userid, int latestInviteIdClient);

	int getLatestInvitationId(int userId);

	// ------------- DELETE -------------
	void deleteInvitation(int invitedId);
}
