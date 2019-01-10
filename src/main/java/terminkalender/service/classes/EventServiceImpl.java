package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.Event;
import terminkalender.service.interfaces.EventService;
import terminkalender.validators.ObjectValidator;

import java.util.List;

public class EventServiceImpl implements EventService {

    private EventDAO eventDAO;


    public EventServiceImpl(EventDAO eventDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventDAO);
        this.eventDAO = eventDAO;

    }

    public EventServiceImpl() throws ObjectIstNullException {
        this(DAOObjectBuilder.getEventDaoObject());
    }

    @Override
    public int addEvent(Event event){
        return 0;
    }

    @Override
    public Event getEvent(int eventId){
        return null;
    }

    @Override
    public void updateEvent(Event event){
    }

    @Override
    public void deleteEvent(int eventId){

    }

    @Override
    public List<Event> getAllEventFromUser(int userId){
        return null;
    }
}
