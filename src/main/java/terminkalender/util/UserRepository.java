package terminkalender.util;

import org.springframework.data.jpa.repository.JpaRepository;
import terminkalender.model.interfaces.User;

public interface UserRepository extends JpaRepository <User, Long> {
}
