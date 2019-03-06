package terminkalender.server;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path(UserRessource.webContextPath)
public class UserRessource {
    private Map<Integer, User> userDB = new ConcurrentHashMap<>();
    static final String webContextPath = "/users";

    public UserRessource() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String verifyUser(@PathParam("id") int id) {
        return "User with id " + id + " has been verified";
    }
}
