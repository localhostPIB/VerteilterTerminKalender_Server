package terminkalender.dao.interfaces;

public interface EventDeclineDAO extends ObjectDAO{
    void addDecline(int eventId, int declineUserId);
    void deleteDecline(int eventId, int declineUserId);

    void removeAllEventDecline();
}
