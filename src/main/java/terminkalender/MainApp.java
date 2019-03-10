package terminkalender;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.builders.ModelObjectBuilder;
import terminkalender.dao.classes.EventDAOImpl;
import terminkalender.dao.classes.UserDAOImpl;
import terminkalender.dao.interfaces.*;
import terminkalender.model.classes.EventImpl;
import terminkalender.model.classes.UserImpl;
import terminkalender.model.interfaces.Event;
import terminkalender.model.interfaces.User;

import java.time.LocalDateTime;

public class MainApp {

    private EventDeclineDAO eventDeclineDAO;
    private EventDAO eventDAO;
    private EventInviteDAO eventInviteDAO;
    private EventParticipateDAO eventParticipateDAO;
    private UserDAO userDAO;

    MainApp() {
        this.eventDeclineDAO        = DAOObjectBuilder.getEventDeclineDaoObject();
        this.eventDAO               = DAOObjectBuilder.getEventDaoObject();
        this.eventInviteDAO         = DAOObjectBuilder.getEventInviteDaoObject();
        this.eventParticipateDAO    = DAOObjectBuilder.getEventPaticipateDaoObject();
        this.userDAO                = DAOObjectBuilder.getUserDaoObject();

    }

    private void removeAllRecords() {
        eventDeclineDAO.removeAllEventDecline();
        eventDAO.removeAllEventData();
        eventInviteDAO.removeAllEventInvite();
        eventParticipateDAO.removeAllEventParticipate();
        userDAO.removeAllUserData();
    }



    private void generateData() {
        User tom = ModelObjectBuilder.getUserObject();
        tom.setName("tom");
        tom.setLastName("hanks");
        tom.setPassword("abc1234");
        tom.setEmail("tom@hanks.com");
        userDAO.addUser(tom);

        User john = ModelObjectBuilder.getUserObject();
        john.setName("john");
        john.setLastName("smith");
        john.setPassword("password");
        john.setEmail("john@smith.com");
        userDAO.addUser(john);

        User sarah = ModelObjectBuilder.getUserObject();
        sarah.setName("sarah");
        sarah.setLastName("connor");
        sarah.setPassword("asdfjkl");
        sarah.setEmail("sarah@connor.com");
        userDAO.addUser(sarah);

        User mary = ModelObjectBuilder.getUserObject();
        mary.setName("mary");
        mary.setLastName("jane");
        mary.setPassword("hello");
        mary.setEmail("mary@jane.com");
        userDAO.addUser(mary);

        Event tomEvent1 = ModelObjectBuilder.getEventImplObject();
        tomEvent1.setLocation("HTW");
        tomEvent1.setStartTime(LocalDateTime.now().plusHours(1));
        tomEvent1.setEndTime(LocalDateTime.now().plusHours(2));
        tomEvent1.setAllDay(false);
        tomEvent1.setRepeat(0);
        tomEvent1.setNote("htw event");
        tomEvent1.setUserId(tom.getUserId());
        eventDAO.addEvent(tomEvent1);

        Event tomEvent2 = ModelObjectBuilder.getEventImplObject();
        tomEvent2.setLocation("Saarbrücken");
        tomEvent2.setStartTime(LocalDateTime.now().plusDays(2));
        tomEvent2.setEndTime(LocalDateTime.now().plusDays(2));
        tomEvent2.setAllDay(true);
        tomEvent2.setRepeat(0);
        tomEvent2.setNote("Saarbrücken event");
        tomEvent2.setUserId(tom.getUserId());
        eventDAO.addEvent(tomEvent2);

        Event tomEvent3 = ModelObjectBuilder.getEventImplObject();
        tomEvent3.setLocation("Mensa");
        tomEvent3.setStartTime(LocalDateTime.now().plusMinutes(30));
        tomEvent3.setEndTime(LocalDateTime.now().plusMinutes(60));
        tomEvent3.setAllDay(false);
        tomEvent3.setRepeat(0);
        tomEvent3.setNote("Mensa");
        tomEvent3.setUserId(tom.getUserId());
        eventDAO.addEvent(tomEvent3);

        Event johnEvent1 = ModelObjectBuilder.getEventImplObject();
        johnEvent1.setLocation("Biergarten");
        johnEvent1.setStartTime(LocalDateTime.now().plusMonths(1));
        johnEvent1.setEndTime(LocalDateTime.now().plusMonths(1).plusMinutes(15));
        johnEvent1.setAllDay(false);
        johnEvent1.setRepeat(0);
        johnEvent1.setNote("Bier");
        johnEvent1.setUserId(john.getUserId());
        eventDAO.addEvent(johnEvent1);

        Event sarahEvent1 = ModelObjectBuilder.getEventImplObject();
        sarahEvent1.setLocation("Europa Galerie");
        sarahEvent1.setStartTime(LocalDateTime.now().plusHours(2));
        sarahEvent1.setEndTime(LocalDateTime.now().plusHours(3));
        sarahEvent1.setAllDay(false);
        sarahEvent1.setRepeat(0);
        sarahEvent1.setNote("Europa Galerie");
        sarahEvent1.setUserId(sarah.getUserId());
        eventDAO.addEvent(sarahEvent1);

        Event sarahEvent2 = ModelObjectBuilder.getEventImplObject();
        sarahEvent2.setLocation("Bibliothek");
        sarahEvent2.setStartTime(LocalDateTime.now().plusMinutes(15));
        sarahEvent2.setEndTime(LocalDateTime.now().plusMinutes(15));
        sarahEvent2.setAllDay(true);
        sarahEvent2.setRepeat(0);
        sarahEvent2.setNote("studieren");
        sarahEvent2.setUserId(sarah.getUserId());
        eventDAO.addEvent(sarahEvent2);

        Event maryEvent1 = ModelObjectBuilder.getEventImplObject();
        maryEvent1.setLocation("STL");
        maryEvent1.setStartTime(LocalDateTime.now().plusWeeks(2));
        maryEvent1.setEndTime(LocalDateTime.now().plusWeeks(3));
        maryEvent1.setAllDay(true);
        maryEvent1.setRepeat(0);
        maryEvent1.setNote("Praktikum");
        maryEvent1.setUserId(mary.getUserId());
        eventDAO.addEvent(maryEvent1);

    }

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        //mainApp.removeAllRecords();
        //mainApp.generateData();
    }
}
