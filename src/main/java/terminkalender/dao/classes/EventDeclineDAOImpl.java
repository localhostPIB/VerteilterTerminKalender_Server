package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventDeclineDAO;
import terminkalender.model.interfaces.EventDecline;

public class EventDeclineDAOImpl extends ObjectDAOImpl implements EventDeclineDAO {
    public  EventDeclineDAOImpl(){
        super();
    }

    @Override
    public int addEventDecline(EventDecline eventDecline){
        initTransaction();
        transaction.begin();

        entityManager.persist(eventDecline);
        transaction.commit();
        return 0;
    }

    @Override
    public void deleteEventDecline(int declineId){

    }

    @Override
    public EventDecline getEventDecline(int userId){
        return null;
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
