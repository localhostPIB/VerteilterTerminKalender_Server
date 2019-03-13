package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.model.classes.EventInviteImpl;
import terminkalender.model.interfaces.EventInvite;

import java.util.List;

/**
 * DAO-Class for the EventInvite
 */
public class EventInviteDAOImpl extends ObjectDAOImpl implements EventInviteDAO
{
	/**
	 * constructor, call the ObjectDAO constructor
	 * to initialize connection to database
	 */
    public  EventInviteDAOImpl(){
        super();
    }

	/** ------------- ADD -------------
	 * add new Invitation to the database
	 * @param eventInvite the EventInvite - Object
	 * @return the id of the newly stored invitation
	 */
	@Override
    public int addEventInvite(EventInvite eventInvite){
        initTransaction();
        transaction.begin();

        entityManager.persist(eventInvite);
        transaction.commit();
        int eventInviteId = eventInvite.getInviteId();

        finishTransaction();
        return eventInviteId;
    }

	/**  ------------- GET 1 -------------
	 * find the EventInvite - Object based on its id
	 * @param inviteId the invitation id
	 * @return the EventInvite Object
	 */
	@Override
	public EventInvite getEventInvite(int inviteId) {
		initTransaction();
		transaction.begin();

		EventInvite eventInvite = entityManager.find(EventInviteImpl.class, inviteId);
		if(eventInvite == null) {
			finishTransaction();
			throw new IllegalArgumentException("Event invitation existiert nicht!");
		}

		finishTransaction();
		return eventInvite;
	}

	/** ------------- GET ALL -------------
	 * retrieve all the invitations sent TO the user
	 * @param userId id of the user, whose invitation wants to be found
	 * @return List of all invitations sent TO the user
	 */
	@Override
	public List<EventInvite> getAllInvitationToUser(int userId) {
		initTransaction();
		transaction.begin();

		List<EventInvite> inviteList = entityManager
				.createQuery("SELECT inv FROM EventInviteImpl inv WHERE inv.userId = :userId", EventInvite.class)
				.setParameter("userId", userId)
				.getResultList();

		transaction.commit();
		finishTransaction();
		return inviteList;
	}

	/** ------------- DELETE 1 -------------
	 * delete Invitation from the database
	 * @param inviteId the id of the invitation
	 */
	@Override
    public void deleteEventInvite(int inviteId) {
        initTransaction();
        transaction.begin();

        EventInvite eventInvite = entityManager.find(EventInviteImpl.class, inviteId);
        if(eventInvite == null) {
            finishTransaction();
            throw new IllegalArgumentException("Event invitation existiert nicht!");
        }

        entityManager.remove(eventInvite);
        transaction.commit();
        finishTransaction();
    }

    /** ------------- DELETE ALL -------------
     * DELETE ALL RECORDS FROM EVENT INVITE TABLE
     */
    @Override
    public void removeAllEventInvite() {
        initTransaction();
        transaction.begin();

        entityManager
                .createQuery("DELETE FROM EventInviteImpl")
                .executeUpdate();
        transaction.commit();
        finishTransaction();
    }
}
