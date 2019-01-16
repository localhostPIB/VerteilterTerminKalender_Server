package terminkalender.model.classes;


import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventDecline;

import javax.persistence.*;

@Entity
@Table(name = "eventdecline")
@Getter @Setter
public class EventDeclineImpl implements EventDecline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "declineid", nullable = false, unique = true)
    private int declineId;

    @Column(name = "userid")
    private int userId;

    @Column(name = "eventid")
    private int eventId;
}
