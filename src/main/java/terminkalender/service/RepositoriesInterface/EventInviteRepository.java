package terminkalender.service.RepositoriesInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import terminkalender.model.interfaces.EventInvite;

public interface EventInviteRepository extends JpaRepository<EventInvite, Long> {
}
