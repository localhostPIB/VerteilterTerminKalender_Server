package terminkalender.service.classes;

import terminkalender.dao.interfaces.UserDAO;
import terminkalender.model.interfaces.User;
import terminkalender.service.interfaces.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @POST
    @Path("{userid}")
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public int addUser(@PathParam("userid") int userId){
        return 0;
    }

    @GET
    @Path("{userid}")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public User getUser(@PathParam("userid") int userId){
        return null;
    }

    @PUT
    @Path("{userid}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Override
    public void updateUser(@PathParam("userid") int userId){

    }

    @DELETE
    @Override
    public void deleteUser( int userId){

    }

    @Override
    public boolean verifyUser(String password){
        return true;
    }
}
