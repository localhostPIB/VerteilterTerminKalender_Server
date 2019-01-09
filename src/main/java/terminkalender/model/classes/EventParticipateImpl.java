package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventParticipate;

@Getter @Setter
public class EventParticipateImpl implements EventParticipate
{
	private int userId;
	private int eventId;
}
