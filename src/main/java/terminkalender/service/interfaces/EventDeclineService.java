package terminkalender.service.interfaces;

public interface EventDeclineService {
    public void addDecline(int eventId, int declinedUserId);
    public void deleteDecline(int eventId, int declinedUserId);
}
