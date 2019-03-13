package terminkalender.sse;

import terminkalender.dao.classes.UserDAOImpl;
import terminkalender.model.interfaces.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.InboundSseEvent;
import javax.ws.rs.sse.SseEventSource;
import java.util.function.Consumer;

/**
 * Client side example for consuming SSE
 */
public class SSEClient
{

	public static void main(String... args) throws Exception {

		User tomhanks = new UserDAOImpl().getUserByEmail("tom@hanks.com");
		//last invite id should be latest id of EventInvite / Invitation - Object in the CLIENT-Side,
		//if none just put 0
		int lastinviteid = 112;
		String url = "http://127.0.0.1:8000/sse/invitation/" + tomhanks.getUserId() + "?lastinviteid=" + 0;

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		try (SseEventSource eventSource = SseEventSource.target(target).build()) {

			eventSource.register(onEvent, onError, onComplete);
			eventSource.open();

			//Consuming events for one hour, uncomment these to consume events indefinitely
			Thread.sleep(60 * 60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		client.close();
		System.out.println("End");
	}

	// A new event is received
	private static Consumer<InboundSseEvent> onEvent = (inboundSseEvent) -> {
		String data = inboundSseEvent.readData();
		System.out.println(data);
	};

	//Error
	private static Consumer<Throwable> onError = Throwable::printStackTrace;

	//Connection close and there is nothing to receive
	private static Runnable onComplete = () -> {
		System.out.println("Done!");
	};

}
