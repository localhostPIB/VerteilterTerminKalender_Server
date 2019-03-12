package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.model.classes.EventInviteImpl;
import terminkalender.model.interfaces.Event;
import terminkalender.model.interfaces.EventInvite;

import java.util.List;

public class EventInviteDAOImpl extends ObjectDAOImpl implements EventInviteDAO {

    public  EventInviteDAOImpl(){
        super();
    }

    @Override
    public int addEventInvite(EventInvite eventInvite){
        initTransaction();
        transaction.begin();

        entityManager.persist(eventInvite);
        transaction.commit();
        int eventInviteId = eventInvite.getInviteId();

        finishTransaction();
        return eventInviteId;
    }

    @Override
    public void deleteEventInvite(int inviteId) {
        initTransaction();
        transaction.begin();

        EventInvite eventInvite = entityManager.find(EventInviteImpl.class, inviteId);
        if(eventInvite == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event invitation existiert nicht!");
        }
        entityManager.remove(eventInvite);
        transaction.commit();

        finishTransaction();
    }

    @Override
    public EventInvite getEventInvite(int inviteId) {
        return null;
    }

    @Override
    public List<EventInvite> getAllInvitationFromUser(int userId) {
        initTransaction();
        transaction.begin();

        List<EventInvite> inviteList = entityManager
                .createQuery("SELECT inv FROM EventInviteImpl inv WHERE inv.userId = :userId", EventInvite.class)
                .setParameter("userId", userId)
                .getResultList();

        transaction.commit();
        finishTransaction();

        return inviteList;
    }

    /**
     * DELETE ALL RECORDS FROM EVENT INVITE TABLE
     */
    @Override
    public void removeAllEventInvite() {
        initTransaction();
        transaction.begin();

        entityManager
                .createQuery("DELETE FROM EventInviteImpl")
                .executeUpdate();
        transaction.commit();

        finishTransaction();
    }
}
