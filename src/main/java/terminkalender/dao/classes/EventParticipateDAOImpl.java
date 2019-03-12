package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.model.interfaces.EventParticipate;

public class EventParticipateDAOImpl extends ObjectDAOImpl implements EventParticipateDAO {

    public EventParticipateDAOImpl(){
        super();
    }

    @Override
    public int addEventParticipate(EventParticipate eventParticipate){
        return 0;
    }

    @Override
    public void deleteEventParticipate(int participateId){

    }

    @Override
    public EventParticipate getEventParticipate(int userId){
        return null;
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
