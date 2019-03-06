package terminkalender.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import terminkalender.dao.interfaces.EventDeclineDAO;
import terminkalender.model.interfaces.EventDecline;
import terminkalender.model.interfaces.EventParticipate;
import terminkalender.service.RepositoriesInterface.EventDeclineRepository;
import terminkalender.service.interfaces.EventDeclineService;

@RestController
@RequestMapping("/eventDecline")
public class EventDeclineServiceImpl implements EventDeclineService {

    private EventDeclineDAO eventDeclineDAO;

    @Autowired
    private EventDeclineRepository eventDeclineRepository;

   /* @Override
    public void addDecline(int eventId, int declinedUserId){

    }

    @Override
    public void deleteDecline(int eventId, int declinedUserId){

    }*/

   @PostMapping
   @Override
   public EventDecline addDecline (@RequestBody EventDecline eventDecline){
       return eventDeclineRepository.save(eventDecline);
   }

   @DeleteMapping(path = "/eventId")
   @Override
   public ResponseEntity<?> deleteDecline(@PathVariable("eventId") long declinedUserId) {
       return eventDeclineRepository.findById(declinedUserId)
               .map(record -> {
                   eventDeclineRepository.deleteById(declinedUserId);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
   }
}
