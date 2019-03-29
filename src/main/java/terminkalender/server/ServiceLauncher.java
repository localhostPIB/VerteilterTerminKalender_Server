package terminkalender.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;
import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.*;
import terminkalender.service.classes.*;
import terminkalender.sse.ServerSentEventResource;

import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/**
 * this is class for launching the server,
 * it attached itself to specific address in localhost,
 * registers all service classes that will be used and start
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 * @author Zunic, Kerim
 */
public class ServiceLauncher
{


    public static void main(String[] args) throws InterruptedException, IOException {
        String baseUrl = (args.length > 0) ? args[0] : "http://localhost:8000";

        //TODO: add all service classes to the set and instantiate them
        Set<Class<?>> ServiceClasses = new HashSet<>();

        //USER SERVICE
        UserDAO userDAO = DAOObjectBuilder.getUserDaoObject();
        ServiceClasses.add(new UserServiceImpl(userDAO).getClass());

        //EVENT SERVICE
        EventDAO eventDAO = DAOObjectBuilder.getEventDaoObject();
        ServiceClasses.add(new EventServiceImpl(eventDAO).getClass());

        //EVENT INVITE SERVICE
        EventInviteDAO eventInviteDAO = DAOObjectBuilder.getEventInviteDaoObject();
        ServiceClasses.add(new EventInviteServiceImpl(eventInviteDAO).getClass());

        //EVENT DECLINE SERVICE, also using UserDAO
        EventDeclineDAO eventDeclineDAO = DAOObjectBuilder.getEventDeclineDaoObject();
        ServiceClasses.add(new EventDeclineServiceImpl(eventDeclineDAO, userDAO).getClass());

        //EVENT PARTICIPATE SERVICE, also using UserDAO
        EventParticipateDAO eventParticipateDAO = DAOObjectBuilder.getEventPaticipateDaoObject();
        ServiceClasses.add(new EventParticipateServiceImpl(eventParticipateDAO, userDAO).getClass());

        //SSE
        ServiceClasses.add(ServerSentEventResource.class);
        ServiceClasses.add(SseFeature.class);

        // ---------------- REGISTER ALL SERVICE CLASSES ----------------
        ResourceConfig rc = new ResourceConfig();
        rc.registerClasses(ServiceClasses);

        // ---------------- START THE SERVER ----------------
        final HttpServer server = GrizzlyHttpServerFactory
                                        .createHttpServer(URI.create(baseUrl), rc);

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
        server.start();

        System.out.println("Server start");
        Thread.currentThread().join();
    }
}
