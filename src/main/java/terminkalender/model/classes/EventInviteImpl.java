package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventInvite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "eventinvite")
@Getter @Setter
public class EventInviteImpl implements EventInvite
{
	@Column(name = "userid")
	private int userId;

	@Column(name = "eventid")
	private int eventId;
}