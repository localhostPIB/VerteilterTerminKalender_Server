package terminkalender.dao.interfaces;

public interface EventInviteDAO extends ObjectDAO{
    public void addInvitation(int eventId, int invitedUserId);
    public void deleteInvitation(int eventId, int invitedUserId);
}
