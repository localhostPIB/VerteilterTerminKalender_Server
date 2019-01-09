package terminkalender.service.interfaces;

public interface EventParticipateService
{
	public void addParticipated(int eventId, int participatedUserId);
	public void deleteParticipated(int eventId, int participatedUserId);
}
