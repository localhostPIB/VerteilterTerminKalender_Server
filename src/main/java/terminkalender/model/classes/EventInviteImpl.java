package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.EventInvite;

@Getter @Setter
public class EventInviteImpl implements EventInvite
{
	private int userId;
	private int eventId;
}