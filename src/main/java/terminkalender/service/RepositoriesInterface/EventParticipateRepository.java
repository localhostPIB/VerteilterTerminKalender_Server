package terminkalender.service.RepositoriesInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import terminkalender.model.interfaces.EventParticipate;

public interface EventParticipateRepository extends JpaRepository<EventParticipate, Long> {

}
