package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.EventInvite;
import terminkalender.service.interfaces.EventInviteService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(EventInviteServiceImpl.webContextPath)
public class EventInviteServiceImpl implements EventInviteService {

    private EventInviteDAO eventInviteDAO;
    static final String webContextPath = "invitation";

    private  EventInviteServiceImpl(EventInviteDAO eventInviteDAO) throws ObjectIstNullException{
        ObjectValidator.checkObObjectNullIst(eventInviteDAO);
        this.eventInviteDAO = eventInviteDAO;
    }

    private  EventInviteServiceImpl() throws  ObjectIstNullException{
        this (DAOObjectBuilder.getEventInviteDaoObject());
    }

    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EventInvite addInvitation(EventInvite eventInvite) {
        int newInviteId = eventInviteDAO.addEventInvite(eventInvite);
        return eventInviteDAO.getEventInvite(newInviteId);
    }


    @Override
    @GET
    @Path("{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventInvite getInvitation(@PathParam("userid") int userId) {
        return eventInviteDAO.getEventInvite(userId);
    }

    @Override
    @DELETE
    @Path("delete/{inviteid}")
    public void deleteInvitation(@PathParam("inviteid") int inviteId) {
        eventInviteDAO.deleteEventInvite(inviteId);
    }


}
