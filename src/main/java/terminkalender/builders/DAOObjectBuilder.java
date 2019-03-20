package terminkalender.builders;

import terminkalender.dao.classes.*;
import terminkalender.dao.interfaces.*;

/**
 * Builder class for DAO
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public class DAOObjectBuilder
{

    public static EventDAO getEventDaoObject(){
        return new EventDAOImpl();
    }

    public static UserDAO getUserDaoObject(){
        return new UserDAOImpl();
    }

    public static EventParticipateDAO getEventPaticipateDaoObject(){
        return new EventParticipateDAOImpl();
    }

    public static EventInviteDAO getEventInviteDaoObject(){
        return new EventInviteDAOImpl();
    }

    public static EventDeclineDAO getEventDeclineDaoObject(){
        return new EventDeclineDAOImpl();
    }
}
