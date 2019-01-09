package terminkalender.service.interfaces;

public interface EventInviteService
{
	public void addInvitation(int eventId, int invitedUserId);
	public void deleteInvitation(int eventId, int invitedUserId);
}
