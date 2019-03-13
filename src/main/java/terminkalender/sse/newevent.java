package terminkalender.sse;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.model.classes.EventInviteImpl;
import terminkalender.model.interfaces.EventInvite;

/**
 * test class for adding new event
 */
public class newevent
{
	public static void main(String[] args) {
		EventInviteDAO eventInviteDAO = DAOObjectBuilder.getEventInviteDaoObject();
		EventInvite invite1 = new EventInviteImpl();
		invite1.setUserId(101);
		invite1.setEventId(110);
		eventInviteDAO.addEventInvite(invite1);
		EventInvite invite2 = new EventInviteImpl();
		invite2.setUserId(101);
		invite2.setEventId(109);
		eventInviteDAO.addEventInvite(invite2);
	}
}
