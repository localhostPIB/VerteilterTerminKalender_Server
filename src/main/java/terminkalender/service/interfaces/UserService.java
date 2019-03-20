package terminkalender.service.interfaces;

import terminkalender.model.interfaces.User;

/**
 * Interface for the User
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public interface UserService
{
	// ------------- POST -------------
	User addUser (User user);

	// ------------- GET -------------
	User getUser (String email);

	// ------------- GET -------------
	User getUserByUserId(int userId);

	// ------------- GET -------------
	int getUserIdByEmail(String email);

	// ------------- PUT -------------
	void updateUser(User user);

	// ------------- DELETE -------------
	void deleteUser(String email);

	// ------------- GET -------------
	boolean verifyUser(String email, String password);
}
