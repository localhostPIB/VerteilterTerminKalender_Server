package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventInvite;

import javax.persistence.*;

/**
 * this is model class for the Event Invite Object
 * the Object contains:
 *      its own id as primary key in the database
 *      id of the user as foreign key (user who is invited)
 *      id of the event as foreign key (the event which the user is invited to)
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@Entity
@Table(name = "eventinvite")
@Getter @Setter
public class EventInviteImpl implements EventInvite
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inviteid", nullable = false, unique = true)
	private int inviteId;

	@Column(name = "userid")
	private int userId;

	@Column(name = "eventid")
	private int eventId;
}