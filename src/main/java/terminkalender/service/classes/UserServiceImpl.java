package terminkalender.service.classes;

import terminkalender.dao.interfaces.UserDAO;
import terminkalender.model.interfaces.User;
import terminkalender.service.interfaces.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Override
    public int addUser(User user){
        return 0;
    }

    @Override
    public User getUser(int userId){
        return null;
    }

    @Override
    public void updateUser(User user){

    }

    @Override
    public void deleteUser(int userId){

    }

    @Override
    public boolean verifyUser(String password){
        return true;
    }
}
