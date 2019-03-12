package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventDAO;
import terminkalender.model.classes.EventImpl;
import terminkalender.model.interfaces.Event;

import java.util.List;

/**
 * DAO-Class for the EventDAO
 */
public class EventDAOImpl extends ObjectDAOImpl implements EventDAO
{
    /**
     * constructor, call the ObjectDAO constructor
     * to initialize connection to database
     */
    public EventDAOImpl(){
        super();
    }

    /** ------------- ADD -------------
     * add new Event to the database
     * @param event the Event - Object
     * @return the id of the newly stored event
     */
    @Override
    public int addEvent(Event event) {
        initTransaction();
        transaction.begin();

        entityManager.persist(event);
        transaction.commit();
        int eventID = event.getEventId();

        finishTransaction();
        return eventID;
    }

    /** ------------- GET 1 -------------
     * find the Event - Object based on its id
     * @param eventID the event id
     * @return the Event - Object
     */
    @Override
    public Event getEvent(int eventID) {
        initTransaction();
        transaction.begin();

        Event event = entityManager.find(EventImpl.class, eventID);
        if(event == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event existiert nicht!");
        }

        finishTransaction();
        return event;
    }

    /** ------------- GET ALL -------------
     * retrieve all the events belong to the user created them
     * @param userId the user who creates the events
     * @return List of all Events belongs to the user
     */
    @Override
    public List<Event> getAllEventFromUser(int userId) {
        initTransaction();
        transaction.begin();

        List<Event> eventList = entityManager
                .createQuery("SELECT e FROM EventImpl e WHERE e.userId = :userId", Event.class)
                .setParameter("userId", userId)
                .getResultList();

        transaction.commit();
        finishTransaction();
        return eventList;
    }

    /** ------------- UPDATE -------------
     * update the event in the database
     * @param event the updated event
     */
    @Override
    public void updateEvent(Event event){
        initTransaction();
        transaction.begin();

        Event updateEvent = entityManager.find(EventImpl.class, event.getEventId());
        if(updateEvent == null){
            finishTransaction();
            throw new IllegalArgumentException("Event existiert nicht!");
        }

        entityManager.merge(event);
        transaction.commit();
        finishTransaction();
    }

    /** ------------- DELETE 1 -------------
     * delete event from the database
     * @param eventId id of the to be deleted event
     */
    @Override
    public void deleteEvent(int eventId){
        initTransaction();
        transaction.begin();

        Event event = entityManager.find(EventImpl.class, eventId);
        if(event == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event existiert nicht!");
        }
        entityManager.remove(event);
        transaction.commit();
        finishTransaction();
    }

    /** ------------- DELETE ALL -------------
     * DELETE ALL RECORDS FROM EVENT TABLE
     */
    @Override
    public void removeAllEventData() {
        initTransaction();
        transaction.begin();

        entityManager
                .createQuery("DELETE FROM EventImpl")
                .executeUpdate();
        transaction.commit();
        finishTransaction();
    }


}
