package terminkalender.dao.interfaces;

public interface EventParticipateDAO {
    void addParticipated(int eventId, int participatedUserId);
    void deleteParticipated(int eventId, int participatedUserId);

    void removeAllEventParticipate();
}
