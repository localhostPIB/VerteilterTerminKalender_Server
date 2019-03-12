package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.Event;
import terminkalender.service.interfaces.EventService;
import terminkalender.util.util;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static terminkalender.util.util.convertListEventToJSON;

/**
 * Resource class for Event-Object
 */
@Path(EventServiceImpl.webContextPath)
public class EventServiceImpl implements EventService
{
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
    /** -------------------------------- POST --------------------------------
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
    /** -------------------------------- GET --------------------------------
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

    //ex: localhost:8000/event/user/{userid}
    /** -------------------------------- GET --------------------------------
     * GET-endpoint for retrieving all events from certain user
     * @param userId the id of user whose event wants to be retrieved
     * @return eventlist json-string containing list of all events from the userId
     */
    @Override
    @GET
    @Path("user/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEventFromUser(@PathParam("userid") int userId) {
        List<Event> eventList = eventDAO.getAllEventFromUser(userId);
        return convertListEventToJSON(eventList);
    }

    //ex: localhost:8000/event/eventlist/{userid}?startdate=...&enddate=...
    /** -------------------------------- GET --------------------------------
     * GET-endpoint for retrieving all events from certain user between dates in query parameter
     * @param userId the id of user whose event wants to be retrieved
     * DATE FORMAT : YYYY-MM-DD
     * @param startDate events returned must have start time AFTER / EQUALS this startDate
     * @param endDate events returned must have start time BEFORE / EQUALS this endDate
     * @return eventlist json-string containing list of events from the userId
     */
    @Override
    @GET
    @Path("eventlist/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventListFromUser(@PathParam("userid") int userId,
                                       @QueryParam("startdate") String startDate,
                                       @QueryParam("enddate") String endDate) {
        List<Event> eventList = eventDAO.getAllEventFromUser(userId);

        LocalDate startQuery = util.convertStringToDate(startDate);
        LocalDate endQuery = util.convertStringToDate(endDate);
        Predicate<Event> betweenTwoDates = e ->
                (e.getStartTime().toLocalDate().isAfter(startQuery) || e.getStartTime().toLocalDate().isEqual(startQuery))
             && (e.getStartTime().toLocalDate().isBefore(endQuery)  || e.getStartTime().toLocalDate().isEqual(endQuery));

        eventList = eventList.stream()
                .filter(betweenTwoDates)
                .collect(Collectors.toList());

        return convertListEventToJSON(eventList);
    }

    //ex: localhost:8000/event/update {request body containing the updated event}
    /** -------------------------------- PUT --------------------------------
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

    //ex: localhost:8000/event/delete/{eventid}
    /** -------------------------------- DELETE --------------------------------
     * DELETE-endpoint for deleting event
     * @param eventId the id of the event wants to be deleted
     */
    @Override
    @DELETE
    @Path("delete/{eventid}")
    public void deleteEvent(@PathParam("eventid") int eventId) {
        eventDAO.deleteEvent(eventId);
    }
}
