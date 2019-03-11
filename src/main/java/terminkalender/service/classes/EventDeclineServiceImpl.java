package terminkalender.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventDeclineDAO;
import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.EventDecline;
import terminkalender.model.interfaces.EventParticipate;
import terminkalender.service.RepositoriesInterface.EventDeclineRepository;
import terminkalender.service.interfaces.EventDeclineService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(EventDeclineServiceImpl.webContextPath)
public class EventDeclineServiceImpl implements EventDeclineService {

    private EventDeclineDAO eventDeclineDAO;
    static final String webContextPath = "decline";

    private EventDeclineServiceImpl (EventDeclineDAO eventDeclineDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventDeclineDAO);
        this.eventDeclineDAO = eventDeclineDAO;
    }

    private  EventDeclineServiceImpl() throws  ObjectIstNullException{
        this (DAOObjectBuilder.getEventDeclineDaoObject());
    }

    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EventDecline addDecline (EventDecline eventDecline){
        int newDeclineId = eventDeclineDAO.addEventDecline(eventDecline);
        return  eventDeclineDAO.getEventDecline(newDeclineId);
    }


    @Override
    @GET
    @Path("{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventDecline getDecline(@PathParam("userid") int userId){
        return eventDeclineDAO.getEventDecline(userId);
    }



    @Override
    @DELETE
    @Path("delete/{declineid}")
    public void deleteDecline(@PathParam("declineid") int declineId){
        eventDeclineDAO.deleteEventDecline(declineId);
    }



}
