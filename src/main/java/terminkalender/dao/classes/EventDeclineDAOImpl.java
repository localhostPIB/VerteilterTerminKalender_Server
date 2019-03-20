package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventDeclineDAO;
import terminkalender.model.classes.EventDeclineImpl;
import terminkalender.model.interfaces.EventDecline;
import terminkalender.model.interfaces.User;

import java.util.List;

/**
 * DAO-Class for the EventDeclineDAO
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public class EventDeclineDAOImpl extends ObjectDAOImpl implements EventDeclineDAO
{
    /**
     * constructor, call the ObjectDAO constructor
     * to initialize connection to database
     */
    public  EventDeclineDAOImpl(){
        super();
    }

    /** ------------- ADD -------------
     * add new EventDecline to the database
     * @param eventDecline the EventDecline - Object
     * @return the id of the newly stored EventDecline
     */
    @Override
    public int addEventDecline(EventDecline eventDecline) {
        initTransaction();
        transaction.begin();

        entityManager.persist(eventDecline);
        transaction.commit();
        int declineId =  eventDecline.getDeclineId();

        finishTransaction();
        return declineId;
    }

    /** ------------- GET 1 -------------
     * find the EventDecline - Object based on its id
     * @param declineId the EventDecline id
     * @return the EventDecline - Object
     */
    @Override
    public EventDecline getEventDecline(int declineId) {
        initTransaction();
        transaction.begin();

        EventDecline eventDecline = entityManager.find(EventDeclineImpl.class, declineId);
        if(eventDecline == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event Decline existiert nicht!");
        }

        finishTransaction();
        return eventDecline;
    }

    /** ------------- GET ALL -------------
     * find the all the users who decline an event
     * @param eventId id of an event
     * @return list of id of the user who decline an event
     */
    @Override
    public List<Integer> getUserWhoDecline(int eventId) {
        initTransaction();
        transaction.begin();

        List<Integer> userList = entityManager
                .createQuery("SELECT dec.userId FROM EventDeclineImpl dec WHERE dec.eventId = :eventId",
                                Integer.class)
                .setParameter("eventId", eventId)
                .getResultList();

        transaction.commit();
        finishTransaction();

        return userList;
    }

    /** ------------- DELETE 1 -------------
     * delete EventDecline from the database
     * @param declineId the id of the EventDecline
     */
    @Override
    public void deleteEventDecline(int declineId) {
        initTransaction();
        transaction.begin();

        EventDecline eventDecline = entityManager.find(EventDeclineImpl.class, declineId);
        if(eventDecline == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event Decline existiert nicht!");
        }

        entityManager.remove(eventDecline);
        transaction.commit();
        finishTransaction();
    }

    /** ------------- DELETE ALL -------------
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
