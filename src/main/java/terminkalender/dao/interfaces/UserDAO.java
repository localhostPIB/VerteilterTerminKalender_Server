package terminkalender.dao.interfaces;

import terminkalender.model.interfaces.User;

public interface UserDAO extends ObjectDAO{
    public int addUser(User user);
    public User getUser(int userId);
    public void updateUser(User user);
    public void deleteUser(int userId);
    public boolean verifyUser(int userId, String password);
}
