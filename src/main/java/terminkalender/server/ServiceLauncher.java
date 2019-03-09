package terminkalender.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import terminkalender.service.classes.*;

import java.io.IOException;
import java.net.URI;

/**
 *
 */
public class ServiceLauncher {
    public static void main(String[] args) throws InterruptedException, IOException {
        String baseUrl = (args.length > 0) ? args[0] : "http://localhost:8000";
        ResourceConfig rc = new ResourceConfig();
        //rc.registerInstances(new UserRessource(), new UserRessource2()); //TODO: DELETE THIS LINE AFTER TESTING
        rc.registerInstances(new EventDeclineServiceImpl(), new EventInviteServiceImpl(), new EventPaticipateServiceImpl(), new EventServiceImpl(), new UserServiceImpl());

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUrl), rc, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.shutdownNow();
            }
        }));
        server.start();

        System.out.println("Server start");
        Thread.currentThread().join();
    }
}
