package terminkalender.service.interfaces;

import terminkalender.model.interfaces.User;

/**
 * Interface for the User
 */
public interface UserService
{
	// ------------- POST -------------
	User addUser (User user);

	// ------------- GET -------------
	User getUser (String email);

	// ------------- GET -------------
	int getUserIdByEmail(String email);

	// ------------- PUT -------------
	void updateUser(User user);

	// ------------- DELETE -------------
	void deleteUser(String email);

	// ------------- GET -------------
	boolean verifyUser(String email, String password);
}
