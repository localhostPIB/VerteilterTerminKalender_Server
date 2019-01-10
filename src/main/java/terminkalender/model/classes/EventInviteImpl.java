package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventInvite;

import javax.persistence.*;

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