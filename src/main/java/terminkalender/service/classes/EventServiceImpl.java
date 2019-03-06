package terminkalender.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.Event;
import terminkalender.service.RepositoriesInterface.EventRepository;
import terminkalender.service.interfaces.EventService;
import terminkalender.validators.ObjectValidator;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventServiceImpl implements EventService {

    private EventDAO eventDAO;

    @Autowired
    private EventRepository eventRepository;

    private EventServiceImpl(EventDAO eventDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(eventDAO);
        this.eventDAO = eventDAO;

    }

    public EventServiceImpl() throws ObjectIstNullException {
        this(DAOObjectBuilder.getEventDaoObject());
    }

    /*@POST
    @Path("{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    @Override
    public int addEvent(@PathParam("eventid") int eventId){
        return 0;
    }

    @GET
    @Path("{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Event getEvent(@PathParam("eventid") int eventId){
        return null;
    }

    @PUT
    @Path("{eventid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void updateEvent(@PathParam("eventid") int eventId){
    }

    @DELETE
    @Override
    public void deleteEvent(int eventId){

    }*/

    //TODO nicht sicher ob wir den Path userId oder mit eventId benutzen, muss noch server implementieren, um zu testen

    @PostMapping
    @Override
    public Event addEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }

    @PutMapping(value = "/{userId}")
    @Override
    public ResponseEntity<Event> updateEvent (@PathVariable("userId") long eventId,
                                           @RequestBody Event event){
        return eventRepository.findById(eventId)
                .map(record -> {
                    record.setEndTime(event.getEndTime());
                    record.setLocation(event.getLocation());
                    record.setNote(event.getNote());
                    record.setAllDay(event.isAllDay());
                    record.setStartTime(event.getStartTime());
                    record.setRepeat(event.getRepeat());
                    Event updated = eventRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/{userId}")
    @Override
    public ResponseEntity<Event> getEvent (@PathVariable long eventId){
        return eventRepository.findById(eventId)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{userId}")
    @Override
    public ResponseEntity<?> deleteEvent(@PathVariable("userId") long eventId) {
        return eventRepository.findById(eventId)
                .map(record -> {
                    eventRepository.deleteById(eventId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List<Event> getAllEventFromUser(int userId){
        return null;
    }
}
