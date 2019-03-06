package terminkalender.service.RepositoriesInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import terminkalender.model.interfaces.EventDecline;

public interface EventDeclineRepository extends JpaRepository<EventDecline, Long> {
}
