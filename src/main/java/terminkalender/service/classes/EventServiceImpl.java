package terminkalender.service.classes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.Event;
import terminkalender.service.interfaces.EventService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * Resource class for Event-Object
 */
@Path(EventServiceImpl.webContextPath)
public class EventServiceImpl implements EventService {

    private EventDAO eventDAO;
    static final String webContextPath ="event";

    private EventServiceImpl(EventDAO eventDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventDAO);
        this.eventDAO = eventDAO;
    }

    public EventServiceImpl() throws ObjectIstNullException {
        this(DAOObjectBuilder.getEventDaoObject());
    }

    //ex: localhost:8000/event/add {request body containing the new event}
    /**
     * POST-endpoint for adding new event
     * request body should contain event object WITHOUT the id and WITHOUT the duration
     * @param event the new event to be added
     * @return the new event after stored in the database and given id
     */
    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Event addEvent(Event event) {
        int newEventId = eventDAO.addEvent(event);
        return eventDAO.getEvent(newEventId);
    }

    //ex: localhost:8000/event/{eventid}
    /**
     * GET-endpoint for retrieving event
     * @param eventId the id of the event wants to be retrieved
     * @return the event having the eventId
     */
    @Override
    @GET
    @Path("{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEvent(@PathParam("eventid") int eventId) {
        return eventDAO.getEvent(eventId);
    }

    //ex: localhost:8000/event/update {request body containing the updated event}
    /**
     * PUT-endpoint for updating event
     * request body should contain user object WITH the id and WITHOUT the duration
     * @param event the event wants to be updated
     */
    @Override
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEvent(Event event) {
        eventDAO.updateEvent(event);
    }

    //ex: localhost:8000/event/delete/15
    /**
     * DELETE-endpoint for deleting event
     * @param eventId the id of the event wants to be deleted
     */
    @Override
    @DELETE
    @Path("delete/{eventid}")
    public void deleteEvent(@PathParam("eventid") int eventId) {
        eventDAO.deleteEvent(eventId);
    }

    //ex: localhost:8000/event/user/{userid}
    /**
     * GET-endpoint for retrieving all events from certain user
     * @param userId the id of user whose event wants to be retrieved
     * @return eventlist json-string containing list of all events from the userId
     */
    @Override
    @GET
    @Path("user/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEventFromUser(@PathParam("userid") int userId) {
        String eventlist = "";
        List<Event> events = eventDAO.getAllEventFromUser(userId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            eventlist = objectMapper.writeValueAsString(events);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return eventlist;
    }

    @Override
    @GET
    @Path("eventlist/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public  String getEventListFromUser(@PathParam("userid") int userId, @QueryParam("startdate")String startDate, @QueryParam("enddate") String endDate){
        String eventlist = "";
        List<Event> events = eventDAO.getEventBetweenDate(userId, startDate, endDate);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            eventlist = objectMapper.writeValueAsString(events);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return eventlist;

    }


}
