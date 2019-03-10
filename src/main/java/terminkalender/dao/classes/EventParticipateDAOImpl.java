package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventParticipateDAO;

public class EventParticipateDAOImpl extends ObjectDAOImpl implements EventParticipateDAO {

    public EventParticipateDAOImpl(){
        super();
    }

    @Override
    public void addParticipated(int eventId, int participatedUserId){

    }

    @Override
    public void deleteParticipated(int eventId, int participatedUserId){

    }

    /**
     * DELETE ALL RECORDS FROM EVENT PARTICIPATE TABLE
     */
    @Override
    public void removeAllEventParticipate() {
        initTransaction();
        transaction.begin();

        entityManager
                .createQuery("DELETE FROM EventParticipateImpl")
                .executeUpdate();
        transaction.commit();

        finishTransaction();
    }

}
