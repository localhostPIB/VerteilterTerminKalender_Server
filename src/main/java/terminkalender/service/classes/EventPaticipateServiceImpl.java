package terminkalender.service.classes;

import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.service.interfaces.EventParticipateService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public class EventPaticipateServiceImpl implements EventParticipateService {

    private EventParticipateDAO eventParticipateDAO;

    @POST
    @Override
    public void addParticipated(int eventId, int participatedUserId){

    }

    @DELETE
    @Override
    public void deleteParticipated(int eventId, int participatedUserId){

    }
}

