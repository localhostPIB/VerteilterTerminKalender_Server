package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.model.interfaces.EventInvite;

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

        return eventInviteId;
    }

    @Override
    public void deleteEventInvite(int inviteId){

    }

    @Override
    public EventInvite getEventInvite(int userId){
        return null;
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
