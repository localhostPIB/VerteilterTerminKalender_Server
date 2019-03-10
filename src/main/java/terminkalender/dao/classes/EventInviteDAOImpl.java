package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventInviteDAO;

public class EventInviteDAOImpl extends ObjectDAOImpl implements EventInviteDAO {

    public  EventInviteDAOImpl(){
        super();
    }

    @Override
    public void addInvitation(int eventId, int invitedUserId){
        initTransaction();
        transaction.begin();

        entityManager.persist(eventId);
        transaction.commit();
    }

    @Override
    public void deleteInvitation(int eventId, int invitedUserId){

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
