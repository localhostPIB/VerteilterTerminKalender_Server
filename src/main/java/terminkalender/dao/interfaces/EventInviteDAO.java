package terminkalender.dao.interfaces;

public interface EventInviteDAO extends ObjectDAO{
    void addInvitation(int eventId, int invitedUserId);
    void deleteInvitation(int eventId, int invitedUserId);

    void removeAllEventInvite();
}
