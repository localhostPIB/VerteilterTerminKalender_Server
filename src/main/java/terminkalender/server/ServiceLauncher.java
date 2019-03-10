package terminkalender.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import terminkalender.service.classes.*;

import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class ServiceLauncher {
    public static void main(String[] args) throws InterruptedException, IOException {
        String baseUrl = (args.length > 0) ? args[0] : "http://localhost:8000";

        //TODO: add all service classes to the set and instantiate them
        Set<Class<?>> ServiceClasses = new HashSet<>();
        ServiceClasses.add(new UserServiceImpl().getClass());
        ServiceClasses.add(new EventServiceImpl().getClass());
//        ServiceClasses.add(new EventDeclineServiceImpl().getClass());
//        ServiceClasses.add(new EventInviteServiceImpl().getClass());
//        ServiceClasses.add(new EventPaticipateServiceImpl().getClass());

        ResourceConfig rc = new ResourceConfig();
        rc.registerClasses(ServiceClasses);

        final HttpServer server = GrizzlyHttpServerFactory
                                        .createHttpServer(URI.create(baseUrl), rc);

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
        server.start();

        System.out.println("Server start");
        Thread.currentThread().join();
    }
}
