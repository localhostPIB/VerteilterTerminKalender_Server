package terminkalender.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.model.interfaces.EventInvite;
import terminkalender.service.RepositoriesInterface.EventInviteRepository;
import terminkalender.service.interfaces.EventInviteService;

@RestController
@RequestMapping("/invitation")
public class EventInviteServiceImpl implements EventInviteService {

    private EventInviteDAO eventInviteDAO;

    @Autowired
    private EventInviteRepository eventInviteRepository;


  /*  @Override
    public void addInvitation(int eventId, int invitedUserId){

    }

    @Override
    public void deleteInvitation(int eventId, int invitedUserId){

    }*/

  @PostMapping
  @Override
  public EventInvite addInvitation(@RequestBody EventInvite eventInvite){
      return eventInviteRepository.save(eventInvite);
  }

  @DeleteMapping(path = "/userId")
  @Override
  public ResponseEntity<?> deleteInvitation(@PathVariable("userId") long invitedUserId) {
      return eventInviteRepository.findById(invitedUserId)
              .map(record -> {
                  eventInviteRepository.deleteById(invitedUserId);
                  return ResponseEntity.ok().build();
              }).orElse(ResponseEntity.notFound().build());
  }

}
