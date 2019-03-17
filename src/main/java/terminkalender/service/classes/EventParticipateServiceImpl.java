package terminkalender.service.classes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.dao.interfaces.UserDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.EventParticipate;
import terminkalender.model.interfaces.User;
import terminkalender.service.interfaces.EventParticipateService;
import terminkalender.util.Views;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Resource / Service class for Event Participate - Object
 */
@Path(EventParticipateServiceImpl.webContextPath)
public class EventParticipateServiceImpl implements EventParticipateService
{

    private EventParticipateDAO eventParticipateDAO;
    private UserDAO userDAO;
    static final String webContextPath = "participate";

    private EventParticipateServiceImpl(EventParticipateDAO eventParticipateDAO, UserDAO userDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventParticipateDAO);
        ObjectValidator.checkObObjectNullIst(userDAO);
        this.eventParticipateDAO = eventParticipateDAO;
        this.userDAO = userDAO;
    }

    public EventParticipateServiceImpl() throws  ObjectIstNullException {
        this (DAOObjectBuilder.getEventPaticipateDaoObject(), DAOObjectBuilder.getUserDaoObject());
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
    /** -------------------------------- GET --------------------------------
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

    //ex: localhost:8000/participate/event/{eventid}
    /** ------------- GET ALL USER WHO ACCEPT------------------------------
     * GET-endpoint for retrieving all user who accept the event
     * @param eventId
     * @return all user who accept the event
     */
    @Override
    @GET
    @Path("event/{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserWhoAccept(@PathParam("eventid") int eventId){
        String result = "";
        List<Integer> listOfUserId = eventParticipateDAO.getUserWhoAccept(eventId);

        List<User> userList = new ArrayList<>();
        for(int i: listOfUserId) {
            userList.add(userDAO.getUserById(i));
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        try {
            result = mapper.writerWithView(Views.Public.class)
                           .writeValueAsString(userList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;

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

