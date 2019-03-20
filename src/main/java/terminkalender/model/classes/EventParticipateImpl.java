package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventParticipate;

import javax.persistence.*;

/**
 * this is model class for the Event Participate Object
 * the Object contains:
 *      its own id as primary key in the database
 *      id of the user as foreign key (user who accepts an invitation)
 *      id of the event as foreign key (the event which the user accepts to)
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
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
