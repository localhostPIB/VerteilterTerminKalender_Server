package terminkalender.sse;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import terminkalender.dao.classes.EventInviteDAOImpl;
import terminkalender.dao.interfaces.EventInviteDAO;
import terminkalender.model.interfaces.EventInvite;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * SSE Implementation class for EventInvite / Invitation Objects
 */
@Path("sse")
public class ServerSentEventResource
{
	private static volatile EventOutput eventOutput = new EventOutput();
	private EventInviteDAO eventInviteDAO;

	public ServerSentEventResource() {
		this.eventInviteDAO = new EventInviteDAOImpl();
	}

	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getMessageQueue() {
		return eventOutput;
	}

	@POST
	public void addMessage(final String message) throws IOException {
		final EventOutput localOutput = eventOutput;
		if (localOutput != null) {
			eventOutput.write(new OutboundEvent.Builder().name("custom-message").data(String.class, message).build());
		}
	}

	//ex: http://localhost:8000/sse/invitation/{userid}?latestinviteid={latest invite id of Eventinvite - Object in client side, 0 if there is none}
	/** -------------------------------- GET --------------------------------
	 * GET-Endpoint für Invitation SSE
	 * @param userid id of the user
	 * @param latestInviteIdClient latest invite id of Eventinvite - Object in client side, 0 if there is none
	 * @return SSE EventOutput
	 */
	@GET
	@Path("invitation/{userid}")
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput startDomain(@PathParam("userid") final int userid,
								   @QueryParam("lastinviteid") int latestInviteIdClient) {
		final EventOutput seq = new EventOutput();

		new Thread(() -> {
			boolean running = true;
			int latestIdClient = latestInviteIdClient;				//holding latest id in client
			int latestIdServer;										//holding latest id in database
			List<EventInvite> latestInvitationsInDB;				//holding list of newer EventInvite-Objects than ones
																	// in the client side

			while(running) {
				try {
					//check if there is new invitation in the database
					latestIdServer = eventInviteDAO.getLatestInviteIdToUser(userid);
					if(latestIdServer == latestIdClient) {			//no new change
						Thread.sleep(5000);
						continue;
					}

					//there is new invitations newer than in the client, retrieve them
					latestInvitationsInDB = eventInviteDAO.getLatestInviteToUser(userid, latestIdClient);
					if (latestInvitationsInDB != null && latestInvitationsInDB.size() > 0) {
						OutboundEvent outboundEvent = new OutboundEvent.Builder().name("New Invitation")
								.mediaType(MediaType.APPLICATION_JSON_TYPE)
								.data(EventInvite.class, latestInvitationsInDB)
								.build();
						seq.write(outboundEvent);

						//update the client id counter by selecting the biggest id in the list
						latestIdClient = latestInvitationsInDB.stream()
															  .max(Comparator.comparing(EventInvite::getInviteId))
															  .get()
															  .getInviteId();
						Thread.sleep(5000);
					}

					//seq.close();

				} catch (final InterruptedException | IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		return seq;
	}

	@DELETE
	public void close() throws IOException {
		final EventOutput localOutput = eventOutput;
		if (localOutput != null) {
			eventOutput.close();
		}
		ServerSentEventResource.setEventOutput(new EventOutput());
	}

	private static void setEventOutput(final EventOutput eventOutput) {
		ServerSentEventResource.eventOutput = eventOutput;
	}
}
