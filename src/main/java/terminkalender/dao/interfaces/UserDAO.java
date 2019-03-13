package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.User;

/**
 * Interface for the EventDAO
 */
public interface UserDAO extends ObjectDAO
{
    // ------------- ADD -------------
    int addUser(User user);

    // ------------- GET 1 -------------
    User getUserById(int userId);

    // ------------- GET 1-------------
    User getUserByEmail(String email);

    // ------------- UPDATE -------------
    void updateUser(User user);

    // ------------- DELETE 1 -------------
    void deleteUserById(int userId);

    // ------------- DELETE ALL -------------
    void removeAllUserData();

    // ------------- VERIFY -------------
    boolean verifyUser(int userId, String password);
}
