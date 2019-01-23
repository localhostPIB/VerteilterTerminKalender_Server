package terminkalender.service.interfaces;

import terminkalender.model.interfaces.User;

public interface UserService
{
	public int addUser(int userId);
	public User getUser(int userId);
	public void updateUser(int userId);
	public void deleteUser(int userId);

	public boolean verifyUser(String password);
}
