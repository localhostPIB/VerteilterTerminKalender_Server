package terminkalender.service.RepositoriesInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import terminkalender.model.interfaces.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
