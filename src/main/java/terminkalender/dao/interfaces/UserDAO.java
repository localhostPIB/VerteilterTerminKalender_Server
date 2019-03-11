package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.User;

public interface UserDAO extends ObjectDAO{
    int addUser(User user);
    User getUserById(int userId);
    User getUserByEmail(String email);
    void updateUser(User user);
    void deleteUserById(int userId);
    boolean verifyUser(int userId, String password);

    void removeAllUserData();
}
