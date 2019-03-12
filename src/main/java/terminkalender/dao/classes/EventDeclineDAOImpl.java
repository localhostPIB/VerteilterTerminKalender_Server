package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventDeclineDAO;
import terminkalender.model.classes.EventDeclineImpl;
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
        int declineId =  eventDecline.getDeclineId();

        finishTransaction();
        return declineId;
    }

    @Override
    public void deleteEventDecline(int declineId) {
        initTransaction();
        transaction.begin();

        EventDecline eventDecline = entityManager.find(EventDeclineImpl.class, declineId);
        if(eventDecline == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event decline existiert nicht!");
        }
        entityManager.remove(eventDecline);
        transaction.commit();

        finishTransaction();
    }

    @Override
    public EventDecline getEventDecline(int userId) {
        initTransaction();
        transaction.begin();

        transaction.commit();
        finishTransaction();
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
