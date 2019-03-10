package terminkalender.builders;

import terminkalender.model.classes.*;
import terminkalender.model.interfaces.EventDecline;
import terminkalender.model.interfaces.EventInvite;
import terminkalender.model.interfaces.EventParticipate;
import terminkalender.model.interfaces.User;

public class ModelObjectBuilder
{
	public static EventDecline getEventDeclineObject() {
		return new EventDeclineImpl();
	}

	public static EventImpl getEventImplObject() {
		return new EventImpl();
	}

	public static EventInvite getEventInviteObject() {
		return new EventInviteImpl();
	}

	public static EventParticipate getEventParticipateObject() {
		return new EventParticipateImpl();
	}

	public static User getUserObject() {
		return new UserImpl();
	}
}
