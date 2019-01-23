package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.Event;
import terminkalender.service.interfaces.EventService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
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

    @POST
    @Path("{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    @Override
    public int addEvent(@PathParam("eventid") int eventId){
        return 0;
    }

    @GET
    @Path("{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Event getEvent(@PathParam("eventid") int eventId){
        return null;
    }

    @PUT
    @Path("{eventid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void updateEvent(@PathParam("eventid") int eventId){
    }

    @DELETE
    @Override
    public void deleteEvent(int eventId){

    }

    @Override
    public List<Event> getAllEventFromUser(int userId){
        return null;
    }
}
