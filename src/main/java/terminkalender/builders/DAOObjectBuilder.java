package terminkalender.builders;

import terminkalender.dao.classes.EventDAOImpl;
import terminkalender.dao.classes.EventInviteDAOImpl;
import terminkalender.dao.classes.EventParticipateDAOImpl;
import terminkalender.dao.classes.UserDAOImpl;
import terminkalender.dao.interfaces.EventDAO;
import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.dao.interfaces.EventParticipateDAO;
import terminkalender.dao.interfaces.UserDAO;

public class DAOObjectBuilder {

    public static EventDAO getEventDaoObject(){
        return new EventDAOImpl();
    }

    public static UserDAO getUserDaoObject(){
        return new UserDAOImpl();
    }

    public static EventParticipateDAO getEventPaticipateDaoObject(){
        return new EventParticipateDAOImpl();
    }

    public  static EventInviteDAO getEventInviteDaoObject(){
        return new EventInviteDAOImpl();
    }
}
