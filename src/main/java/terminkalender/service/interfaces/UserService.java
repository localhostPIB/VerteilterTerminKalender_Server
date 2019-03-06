package terminkalender.service.interfaces;

import org.springframework.http.ResponseEntity;
import terminkalender.model.interfaces.User;
import javax.ws.rs.core.Response;

public interface UserService
{
	public User addUser (User user);
	public ResponseEntity<User> getUser (long userId);
	public ResponseEntity<User> updateUser(long userId, User user);
	public ResponseEntity<?> deleteUser(long userId);

	public boolean verifyUser(String password);
}
