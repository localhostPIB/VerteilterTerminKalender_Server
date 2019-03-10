package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventDeclineDAO;

public class EventDeclineDAOImpl extends ObjectDAOImpl implements EventDeclineDAO {
    public  EventDeclineDAOImpl(){
        super();
    }

    @Override
    public void addDecline(int eventId, int declineUserId){
        initTransaction();
        transaction.begin();

        entityManager.persist(eventId);
        transaction.commit();
    }

    @Override
    public void deleteDecline(int eventId, int declineUserId){

    }

    /**
     * DELETE ALL RECORDS FROM EVENT DECLINE TABLE
     */
    @Override
    public void removeAllEventDecline() {
        initTransaction();
        transaction.begin();

        entityManager
                .createQuery("DELETE FROM EventDeclineImpl")
                .executeUpdate();
        transaction.commit();

        finishTransaction();
    }
}
