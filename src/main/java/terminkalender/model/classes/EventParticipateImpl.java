package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventParticipate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "eventparticipate")
@Getter @Setter
public class EventParticipateImpl implements EventParticipate
{
	@Column(name = "userid")
	private int userId;

	@Column(name = "eventid")
	private int eventId;
}
