package terminkalender.service.interfaces;

import terminkalender.model.interfaces.User;
import javax.ws.rs.core.Response;

public interface UserService
{
	public User addUser (User user);
	public User getUser (String email);
	public void updateUser(User user);
	public void deleteUser(int userId);
	public boolean verifyUser(int userId, String password);
}
