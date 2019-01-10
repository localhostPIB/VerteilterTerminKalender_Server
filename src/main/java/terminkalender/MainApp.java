package terminkalender;

import terminkalender.dao.classes.UserDAOImpl;
import terminkalender.dao.interfaces.UserDAO;
import terminkalender.model.classes.UserImpl;
import terminkalender.model.interfaces.User;

public class MainApp {

    public static void main(String[] args) {
        User user1 = new UserImpl();
        user1.setName("sdsa");
        user1.setLastName("sdfsa");
        user1.setPassword("sdfa");
        user1.setEmail("wqje");

        UserDAO userDAO = new UserDAOImpl();
        userDAO.addUser(user1);


    }
}
