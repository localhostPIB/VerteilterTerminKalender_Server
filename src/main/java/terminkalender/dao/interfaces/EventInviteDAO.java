package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.EventInvite;

public interface EventInviteDAO extends ObjectDAO{
    int addEventInvite(EventInvite eventInvite);
    void deleteEventInvite(int inviteId);
    EventInvite getEventInvite(int userId);

    void removeAllEventInvite();
}
