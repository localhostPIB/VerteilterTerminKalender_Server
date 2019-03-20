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
import terminkalender.util.util;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Resource / Service class for Event Participate - Object
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@Path(EventParticipateServiceImpl.webContextPath)
public class EventParticipateServiceImpl implements EventParticipateService
{
    private EventParticipateDAO eventParticipateDAO;
    private UserDAO userDAO;
    static final String webContextPath = "participate";

    /**
     * constructor, the DAOs is passed as parameters
     * @param eventParticipateDAO DAO for EventParticipate
     * @param userDAO DAO for User
     * @throws ObjectIstNullException if there is DAO Object that has not been instantiated
     */
    public EventParticipateServiceImpl(EventParticipateDAO eventParticipateDAO, UserDAO userDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventParticipateDAO);
        ObjectValidator.checkObObjectNullIst(userDAO);
        this.eventParticipateDAO = eventParticipateDAO;
        this.userDAO = userDAO;
    }

    /**
     * standard constructor for generating the DAOs with the builder
     * @throws ObjectIstNullException when some object is null
     */
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
     * @param eventId id of the event
     * @return all user who accept the event
     */
    @Override
    @GET
    @Path("event/{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserWhoAccept(@PathParam("eventid") int eventId){
        String result = "";
        List<Integer> listOfUserId = eventParticipateDAO.getUserWhoAccept(eventId);
        List<User> userList = listOfUserId.stream()
                                          .map(userDAO::getUserById)
                                          .collect(Collectors.toList());
        return util.convertUserListToNameList(userList);
    }

    //ex: localhost:8000/participate/user/{userid}
    /** ------------- GET ALL PARTICIPATE ------------------------------
     * GET-endpoint for retrieving all participate objekt from the user
     * participate object contains event id, which then can be used to
     * retrieve related event that the user has accepted
     * @param userId id of the user
     * @return String containing list of EventParticipate from this user
     */
    @Override
    @GET
    @Path("user/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllParticipate(@PathParam("userid") int userId) {
        List<EventParticipate> allParticipate = eventParticipateDAO.getAllParticipate(userId);
        return util.convertListToJSON(allParticipate);
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

