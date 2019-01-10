package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventParticipate;

import javax.persistence.*;

@Entity
@Table(name = "eventparticipate")
@Getter @Setter
public class EventParticipateImpl implements EventParticipate
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "participateid", nullable = false, unique = true)
	private int participateId;

	@Column(name = "userid")
	private int userId;

	@Column(name = "eventid")
	private int eventId;
}
