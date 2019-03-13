package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.Event;
import terminkalender.model.interfaces.EventInvite;

/**
 * Interface for the EventInviteService
 */
public interface EventInviteService
{
	// ------------- POST -------------
	EventInvite addInvitation(EventInvite eventInvite);

	// ------------- GET -------------
	EventInvite getInvitation(int userId);

	// ------------- GET -------------
	String getInvitationToUser(int userId);

	// ------------- DELETE -------------
	void deleteInvitation(int invitedId);
}
