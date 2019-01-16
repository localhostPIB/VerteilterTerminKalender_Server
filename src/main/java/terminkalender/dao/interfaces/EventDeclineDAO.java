package terminkalender.dao.interfaces;

public interface EventDeclineDAO extends ObjectDAO{
    public void addDecline(int eventId, int declineUserId);
    public void deleteDecline(int eventId, int declineUserId);
}
