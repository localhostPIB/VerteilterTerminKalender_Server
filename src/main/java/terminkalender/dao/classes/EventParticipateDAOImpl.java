package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.model.classes.EventParticipateImpl;
import terminkalender.model.interfaces.EventParticipate;

/**
 * DAO-Class for the EventParticipate
 */
public class EventParticipateDAOImpl extends ObjectDAOImpl implements EventParticipateDAO
{
    /**
     * constructor, call the ObjectDAO constructor
     * to initialize connection to database
     */
    public EventParticipateDAOImpl() {
        super();
    }

    /** ------------- ADD -------------
     * add new EventParticipate to the database
     * @param eventParticipate the EventParticipate - Object
     * @return the id of the newly stored EventParticipate
     */
    @Override
    public int addEventParticipate(EventParticipate eventParticipate) {
        initTransaction();
        transaction.begin();

        entityManager.persist(eventParticipate);
        transaction.commit();
        int eventInviteId = eventParticipate.getParticipateId();

        finishTransaction();
        return eventInviteId;
    }

    /** ------------- GET 1 -------------
     * find the EventParticipate - Object based on its id
     * @param participateId the EventParticipate id
     * @return the EventParticipate - Object
     */
    @Override
    public EventParticipate getEventParticipate(int participateId) {
        initTransaction();
        transaction.begin();

        EventParticipate eventParticipate = entityManager.find(EventParticipateImpl.class, participateId);
        if(eventParticipate == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event Participate existiert nicht!");
        }

        finishTransaction();
        return eventParticipate;
    }

    /** ------------- DELETE 1 -------------
     * delete EventParticipate from the database
     * @param participateId the id of the EventParticipate
     */
    @Override
    public void deleteEventParticipate(int participateId) {
        initTransaction();
        transaction.begin();

        EventParticipate eventParticipate = entityManager.find(EventParticipateImpl.class, participateId);
        if(eventParticipate == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event Participate existiert nicht!");
        }

        entityManager.remove(eventParticipate);
        transaction.commit();
        finishTransaction();
    }

    /** ------------- DELETE ALL -------------
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
