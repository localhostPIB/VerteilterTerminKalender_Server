package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.EventParticipate;
import terminkalender.service.interfaces.EventParticipateService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Resource / Service class for Event Participate - Object
 */
@Path(EventParticipateServiceImpl.webContextPath)
public class EventParticipateServiceImpl implements EventParticipateService
{

    private EventParticipateDAO eventParticipateDAO;
    static final String webContextPath = "participate";

    private EventParticipateServiceImpl(EventParticipateDAO eventParticipateDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventParticipateDAO);
        this.eventParticipateDAO = eventParticipateDAO;
    }

    public EventParticipateServiceImpl() throws  ObjectIstNullException {
        this (DAOObjectBuilder.getEventPaticipateDaoObject());
    }

    //ex: localhost:8000/participate/add {request body containing the new participate object}
    /** -------------------------------- POST --------------------------------
     * POST-endpoint for creating new Event Participate
     * request body should contain event Event Participate object WITHOUT the id
     * @param eventParticipate the new Event Participate object want to be added
     * @return the new Event Participate after stored in the database and given id
     */
    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EventParticipate addParticipation(EventParticipate eventParticipate) {
        int newParticipateId = eventParticipateDAO.addEventParticipate(eventParticipate);
        return eventParticipateDAO.getEventParticipate(newParticipateId);
    }

    //ex: localhost:8000/participate/{participateid} {request body containing the new participate object}
    /** -------------------------------- POST --------------------------------
     * GET-endpoint for retrieving 1 Event Participate
     * @param participateId the id of the Event Participate wants to be retrieved
     * @return the Event Participate Objekt
     */
    @Override
    @GET
    @Path("{participateid}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventParticipate getParticipation(@PathParam("participateid") int participateId) {
        return eventParticipateDAO.getEventParticipate(participateId);
    }

    //ex: localhost:8000/participate/delete/{participateid}
    /** -------------------------------- DELETE --------------------------------
     * DELETE-endpoint for deleting Event Participate
     * @param participateId the id of the Event Participate wants to be deleted
     */
    @Override
    @DELETE
    @Path("delete/{participateid}")
    public void deleteParticipation(@PathParam("participateid") int participateId) {
        eventParticipateDAO.deleteEventParticipate(participateId);
    }


}

