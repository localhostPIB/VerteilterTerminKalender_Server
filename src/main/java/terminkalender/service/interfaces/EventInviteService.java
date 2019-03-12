package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.Event;
import terminkalender.model.interfaces.EventInvite;

public interface EventInviteService
{
	public EventInvite addInvitation(EventInvite eventInvite);
	public EventInvite getInvitation(int userId);
	public void deleteInvitation(int invitedId);
}
