package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.model.classes.EventParticipateImpl;
import terminkalender.model.interfaces.EventParticipate;

import java.util.List;

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

    /** ------------- GET ALL -------------
     * find the all the users who accept an event
     * @param eventId id of an event
     * @return list of id of the user who accept an event
     */
    @Override
    public List<Integer> getUserWhoAccept(int eventId) {
        initTransaction();
        transaction.begin();

        List<Integer> userList = entityManager
                .createQuery("SELECT acc.userId FROM EventParticipateImpl acc WHERE acc.eventId = :eventId",
                        Integer.class)
                .setParameter("eventId", eventId)
                .getResultList();

        transaction.commit();
        finishTransaction();

        return userList;
    }

    /** ------------- GET ALL -------------
     * retrieve all the participate belong to the user
     * @param userId the user who creates the participate
     * @return List of all EventParticipate belongs to the user
     */
    @Override
    public List<EventParticipate> getAllParticipate(int userId) {
        initTransaction();
        transaction.begin();

        List<EventParticipate> participateList = entityManager
                .createQuery("SELECT part FROM EventParticipateImpl part WHERE part.userId = :userId",
                                EventParticipate.class)
                .setParameter("userId", userId)
                .getResultList();

        transaction.commit();
        finishTransaction();
        return participateList;
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
