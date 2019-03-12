package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventInvite;

import java.util.List;

public interface EventInviteDAO extends ObjectDAO{
    int addEventInvite(EventInvite eventInvite);
    void deleteEventInvite(int inviteId);
    EventInvite getEventInvite(int inviteId);
    List<EventInvite> getAllInvitationFromUser(int userId);

    void removeAllEventInvite();
}
