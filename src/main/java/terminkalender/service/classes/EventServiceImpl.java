package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.Event;
import terminkalender.service.interfaces.EventService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/event")
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

    @GET
    @Path("{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Event getEvent(@PathParam("eventid") int eventId){
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
