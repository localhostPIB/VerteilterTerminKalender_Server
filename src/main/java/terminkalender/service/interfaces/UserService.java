package terminkalender.service.interfaces;

import terminkalender.model.interfaces.User;

public interface UserService
{
	public int addUser(User user);
	public User getUser(int userId);
	public void updateUser(User user);
	public void deleteUser(int userId);

	public boolean verifyUser(String password);
}
