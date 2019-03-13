package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventDeclineDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.EventDecline;
import terminkalender.service.interfaces.EventDeclineService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Resource / Service class for Event Decline - Object
 */
@Path(EventDeclineServiceImpl.webContextPath)
public class EventDeclineServiceImpl implements EventDeclineService
{
    private EventDeclineDAO eventDeclineDAO;
    static final String webContextPath = "decline";

    private EventDeclineServiceImpl (EventDeclineDAO eventDeclineDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventDeclineDAO);
        this.eventDeclineDAO = eventDeclineDAO;
    }

    public EventDeclineServiceImpl() throws  ObjectIstNullException{
        this (DAOObjectBuilder.getEventDeclineDaoObject());
    }

    //ex: localhost:8000/decline/add {request body containing the new decline object}
    /** -------------------------------- POST --------------------------------
     * POST-endpoint for creating new Event Decline
     * request body should contain event Event Decline object WITHOUT the id
     * @param eventDecline the new Event Decline object want to be added
     * @return the new Event Decline after stored in the database and given id
     */
    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EventDecline addDecline (EventDecline eventDecline) {
        int newDeclineId = eventDeclineDAO.addEventDecline(eventDecline);
        return  eventDeclineDAO.getEventDecline(newDeclineId);
    }

    //ex: localhost:8000/decline/{declineid}
    /** -------------------------------- GET --------------------------------
     * GET-endpoint for retrieving 1 Event Decline
     * @param declineId the id of the Event Decline wants to be retrieved
     * @return the Event Decline having the declineId
     */
    @Override
    @GET
    @Path("{declineid}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventDecline getDecline(@PathParam("declineid") int declineId) {
        return eventDeclineDAO.getEventDecline(declineId);
    }

    //ex: localhost:8000/decline/delete/{declineid}
    /** -------------------------------- DELETE --------------------------------
     * DELETE-endpoint for deleting Event Decline
     * @param declineId the id of the Event Decline wants to be deleted
     */
    @Override
    @DELETE
    @Path("delete/{declineid}")
    public void deleteDecline(@PathParam("declineid") int declineId) {
        eventDeclineDAO.deleteEventDecline(declineId);
    }
}
