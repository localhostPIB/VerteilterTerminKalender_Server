package terminkalender.dao.classes;

import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.model.classes.EventImpl;
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

	/**
	 * retrieve all the invitations in the database that is newer than what requested
	 * @param userId id of the invitations TO the user
	 * @param latestInviteIdClient latest id of the invitation to this User in the Client-side
	 * @return list of newer EventInvite-Objects than ones in the client side
	 */
	public List<EventInvite> getLatestInviteToUser(int userId, int latestInviteIdClient) {
		initTransaction();
		transaction.begin();

		List<EventInvite> latestInvitation = entityManager
				.createQuery("SELECT inv FROM EventInviteImpl inv WHERE (inv.userId = :userId AND inv.inviteId > :latestInviteIdClient)",
								EventInvite.class)
				.setParameter("userId", userId)
				.setParameter("latestInviteIdClient", latestInviteIdClient)
				.getResultList();

		transaction.commit();
		finishTransaction();
		return latestInvitation;
	}

	/**
	 * find what is the latest id of EventInvite / Invitation belong to the user in database
	 * @param userId id of the user
	 * @return latest id of Eventinvite / Invitation of the user in the database
	 */
	public int getLatestInviteIdToUser(int userId) {
		initTransaction();
		transaction.begin();

		int latestId = entityManager
				.createQuery("SELECT inv.inviteId FROM EventInviteImpl inv WHERE inv.userId = :userId ORDER BY inv.inviteId DESC",
								Integer.class)
				.setParameter("userId", userId)
				.setMaxResults(1)
				.getSingleResult();

		transaction.commit();
		finishTransaction();
		return latestId;
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
