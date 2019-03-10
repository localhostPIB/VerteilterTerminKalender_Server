package terminkalender.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.model.interfaces.Event;
import terminkalender.model.interfaces.EventParticipate;
import terminkalender.service.RepositoriesInterface.EventParticipateRepository;
import terminkalender.service.interfaces.EventParticipateService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path(EventParticipateServiceImpl.webContextPath)
public class EventParticipateServiceImpl implements EventParticipateService {

    private EventParticipateDAO eventParticipateDAO;

    static final String webContextPath = "eventparticipate";

    @Autowired
    EventParticipateRepository eventParticipateRepository;

   /* @POST
    @Override
    public void addParticipated(int eventId, int participatedUserId){

    }*/

    @DELETE
    @Override
    public void deleteParticipated(int participatedUserId){

    }
    @PostMapping
    @Override
    public EventParticipate addParticipated(@RequestBody EventParticipate eventParticipate){
        return eventParticipateRepository.save(eventParticipate);
    }

   /* //TODO nicht sicher ob wir die EventId oder participatedUserId benutzen
    @DeleteMapping(path = "/{eventId}")
    @Override
    public ResponseEntity<?> deleteParticipated(@PathVariable("eventId") long eventId) {
        return eventParticipateRepository.findById(eventId)
                .map(record -> {
                    eventParticipateRepository.deleteById(eventId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }*/
}

