package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventDAO;
import terminkalender.model.classes.EventImpl;
import terminkalender.model.interfaces.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EventDAOImpl extends ObjectDAOImpl implements EventDAO
{
    /**
     * Konstruktor
     */

    public EventDAOImpl(){
        super();
    }


    /**
     *
     * @param event
     * @return
     */
    @Override
    public int addEvent(Event event){
        initTransaction();
        transaction.begin();

        entityManager.persist(event);
        transaction.commit();
        int eventID = event.getEventId();

        finishTransaction();
        return eventID;
    }

    /**
     *
     * @param eventID
     * @return
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

    /**
     *
     * @param event
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

    /**
     *
     * @param eventId
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

    /**
     *
     * @param userId
     * @return
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

    @Override
    public List<Event> getEventBetweenDate(int userId, LocalDateTime startDate, LocalDateTime endDate) {
        List<Event> eventList = getAllEventFromUser(userId);
        return eventList.stream()
                        .filter(e->e.getStartTime().isAfter(startDate) && e.getStartTime().isBefore(endDate))
                        .collect(Collectors.toList());
    }

    /**
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
