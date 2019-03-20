package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventDecline;

import javax.persistence.*;

/**
 * this is model class for the Event Decline Object
 * the Object contains:
 *      its own id as primary key in the database
 *      id of the user as foreign key (user who declines an invitation)
 *      id of the event as foreign key (the event which the user declines to)
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@Entity
@Table(name = "eventdecline")
@Getter @Setter
public class EventDeclineImpl implements EventDecline
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "declineid", nullable = false, unique = true)
    private int declineId;

    @Column(name = "userid")
    private int userId;

    @Column(name = "eventid")
    private int eventId;
}
