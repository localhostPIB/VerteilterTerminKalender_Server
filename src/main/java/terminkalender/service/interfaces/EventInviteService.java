package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.EventInvite;

public interface EventInviteService
{
	public EventInvite addInvitation(EventInvite eventInvite);
	public ResponseEntity<?> deleteInvitation(long invitedUserId);
}
