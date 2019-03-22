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

    /**
     * EventDao-Object
     * @return Implementation EventDAO
     */
    public static EventDAO getEventDaoObject(){
        return new EventDAOImpl();
    }

    /**
     * UserDao-Object
     * @return Implementation UserDAO
     */
    public static UserDAO getUserDaoObject(){
        return new UserDAOImpl();
    }

    /**
     * EventParticipateDao-Object
     * @return Implementation EventParticipateDAO
     */
    public static EventParticipateDAO getEventPaticipateDaoObject(){
        return new EventParticipateDAOImpl();
    }

    /**
     * EventInviteDao-Object
     * @return Implementation EventInviteDAO
     */
    public static EventInviteDAO getEventInviteDaoObject(){
        return new EventInviteDAOImpl();
    }

    /**
     * EventDeclineDao-Object
     * @return Implementation EventDeclineDAO
     */
    public static EventDeclineDAO getEventDeclineDaoObject(){
        return new EventDeclineDAOImpl();
    }
}
