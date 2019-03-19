package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.EventInvite;
import terminkalender.service.interfaces.EventInviteService;
import terminkalender.util.util;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Resource / Service class for EventInvite - Object
 */
@Path(EventInviteServiceImpl.webContextPath)
public class EventInviteServiceImpl implements EventInviteService
{
    private EventInviteDAO eventInviteDAO;
    static final String webContextPath = "invitation";

    public EventInviteServiceImpl(EventInviteDAO eventInviteDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventInviteDAO);
        this.eventInviteDAO = eventInviteDAO;
    }

    public EventInviteServiceImpl() throws  ObjectIstNullException{
        this(DAOObjectBuilder.getEventInviteDaoObject());
    }

    //ex: localhost:8000/invitation/add {request body containing the new invitation}
    /** -------------------------------- POST --------------------------------
     * POST-endpoint for creating new invitation
     * request body should contain event invitation object WITHOUT the id
     * @param eventInvite the new event invitation object want to be added
     * @return the new event invitation after stored in the database and given id
     */
    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EventInvite addInvitation(EventInvite eventInvite) {
        int newInviteId = eventInviteDAO.addEventInvite(eventInvite);
        return eventInviteDAO.getEventInvite(newInviteId);
    }

    //ex: localhost:8000/invitation/{inviteid}
    /** -------------------------------- GET --------------------------------
     * GET-endpoint for retrieving 1 Event Invitation
     * @param inviteId the id of the Invitation wants to be retrieved
     * @return the Event Invitation having the inviteId
     */
    @Override
    @GET
    @Path("{inviteid}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventInvite getInvitation(@PathParam("inviteid") int inviteId) {
        return eventInviteDAO.getEventInvite(inviteId);
    }

    //ex: localhost:8000/invitation/user/{userid}
    /** -------------------------------- GET --------------------------------
     * GET-endpoint for retrieving all invitation sent to the user
     * @param userId the id of the user
     * @return String containing list of invitation sent to this user
     */
    @Override
    @GET
    @Path("user/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getInvitationToUser(@PathParam("userid")int userId) {
        List<EventInvite> invitationList = eventInviteDAO.getAllInvitationToUser(userId);
        return util.convertListToJSON(invitationList);
    }

    /**
     * retrieve all the invitations in the database that is newer than what requested
     * @param userid id of the user
     * @param latestInviteIdClient latest id of the invitation to this user in the client-side
     * @return list of newer EventInvite-Objects than ones in the client side
     */
    public List<EventInvite> getLatestInvitationsToUser(int userid, int latestInviteIdClient) {
        List<EventInvite> lastInvitationsIdDB = eventInviteDAO.getLatestInviteToUser(userid, latestInviteIdClient);
    	return lastInvitationsIdDB;
	}

	/**
	 * find what is the latest id of EventInvite / Invitation belong to the user in database
	 * @param userId id of the user
	 * @return latest id of Eventinvite / Invitation of the user in the database
	 */
	public int getLatestInvitationId(int userId) {
    	int latestId = eventInviteDAO.getLatestInviteIdToUser(userId);
    	return latestId;
	}

    //ex: localhost:8000/invitation/delete/{inviteid}
    /** -------------------------------- DELETE --------------------------------
     * DELETE-endpoint for deleting Event Invitation
     * @param inviteId the id of the Invitation wants to be deleted
     */
    @Override
    @DELETE
    @Path("delete/{inviteid}")
    public void deleteInvitation(@PathParam("inviteid") int inviteId) {
        eventInviteDAO.deleteEventInvite(inviteId);
    }
}
