package terminkalender.dao.interfaces;

public interface EventParticipateDAO {
    public void addParticipated(int eventId, int participatedUserId);
    public void deleteParticipated(int eventId, int participatedUserId);
}
