package terminkalender;

import terminkalender.dao.classes.EventDAOImpl;
import terminkalender.dao.classes.UserDAOImpl;
import terminkalender.dao.interfaces.EventDAO;
import terminkalender.dao.interfaces.UserDAO;
import terminkalender.model.classes.EventImpl;
import terminkalender.model.classes.UserImpl;
import terminkalender.model.interfaces.Event;
import terminkalender.model.interfaces.User;

import java.time.LocalDateTime;

public class MainApp {

    public static void main(String[] args) {
        User user1 = new UserImpl();
        user1.setName("sdsa");
        user1.setLastName("sdfsa");
        user1.setPassword("sdfa");
        user1.setEmail("wqje");

        UserDAO userDAO = new UserDAOImpl();
        userDAO.addUser(user1);

        Event event1 = new EventImpl();
        event1.setLocation("loc1");
        event1.setStartTime(LocalDateTime.now());
        event1.setEndTime(LocalDateTime.now());
        event1.setAllDay(true);
        event1.setRepeat(0);
        event1.setNote("asdkajf");
        event1.setUserId(user1.getUserId());

        Event event2 = new EventImpl();
        event2.setLocation("loc1");
        event2.setStartTime(LocalDateTime.now());
        event2.setEndTime(LocalDateTime.now());
        event2.setAllDay(false);
        event2.setRepeat(0);
        event2.setNote("asdkajf");
        event2.setUserId(user1.getUserId());

        EventDAO eventDAO = new EventDAOImpl();
        eventDAO.addEvent(event1);
        eventDAO.addEvent(event2);



    }
}
