package terminkalender.service.classes;


import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.Event;
import terminkalender.model.interfaces.EventInvite;
import terminkalender.model.interfaces.EventParticipate;
import terminkalender.service.RepositoriesInterface.EventParticipateRepository;
import terminkalender.service.interfaces.EventParticipateService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(EventParticipateServiceImpl.webContextPath)
public class EventParticipateServiceImpl implements EventParticipateService {

    private EventParticipateDAO eventParticipateDAO;
    static final String webContextPath = "participate";

    private EventParticipateServiceImpl(EventParticipateDAO eventParticipateDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventParticipateDAO);
        this.eventParticipateDAO = eventParticipateDAO;
    }

    private  EventParticipateServiceImpl() throws  ObjectIstNullException {
        this (DAOObjectBuilder.getEventPaticipateDaoObject());
    }

    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EventParticipate addParticipation(EventParticipate eventParticipate) {
        int newParticipateId = eventParticipateDAO.addEventParticipate(eventParticipate);
        return eventParticipateDAO.getEventParticipate(newParticipateId);
    }

    @Override
    @GET
    @Path("{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventParticipate getParticipation(@PathParam("userid") int userId) {
        return eventParticipateDAO.getEventParticipate(userId);
    }

    @Override
    @DELETE
    @Path("delete/{participateid}")
    public void deleteParticipation(@PathParam("participateid") int participateId) {
        eventParticipateDAO.deleteEventParticipate(participateId);
    }


}

