package terminkalender.service.classes;

import terminkalender.builders.DAOObjectBuilder;
import terminkalender.dao.interfaces.UserDAO;
import terminkalender.exceptions.ObjectIstNullException;
import terminkalender.model.interfaces.User;
import terminkalender.service.interfaces.UserService;
import terminkalender.validators.ObjectValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Resource class for UserImpl-Object
 */
@Path(UserServiceImpl.webContextPath)
public class UserServiceImpl implements UserService
{
    private UserDAO userDAO;
    static final String webContextPath ="user";

    public UserServiceImpl(UserDAO userDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(userDAO);
        this.userDAO = userDAO;
    }

    public UserServiceImpl() throws ObjectIstNullException {
        this(DAOObjectBuilder.getUserDaoObject());
    }

    //ex: localhost:8000/user/add {request body containing the new user}
    /** -------------------------------- POST --------------------------------
     * POST-endpoint for adding new user
     * request body should contain user object WITHOUT the id
     * @param user the new user to be added
     * @return the new user after stored in the database and given id
     */
    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user) {
        int newUserId = userDAO.addUser(user);
        return userDAO.getUserById(newUserId);
    }

    //ex: localhost:8000/user/{userid}
    /** -------------------------------- GET --------------------------------
     *  GET-endpoint for retrieving user
     * @param userId the userid of the user wants to be retrieved
     *@return the user having the userid
     */
    @Override
    @GET
    @Path("id/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByUserId(@PathParam("userid") int userId){
        return  userDAO.getUserById(userId);
    }

    //ex: localhost:8000/user/{email}
    /** -------------------------------- GET --------------------------------
     * GET-endpoint for retrieving user
     * @param email the email of the user wants to be retrieved
     * @return the user having the email
     */
    @Override
    @GET
    @Path("{email}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getUser(@PathParam("email") String email) {
        return userDAO.getUserByEmail(email);
    }

    //ex: localhost:8000/user/userid?email=...
    /** -------------------------------- GET --------------------------------
     * GET-endpoint for retrieving userid by its email
     * used for creating EventInvite-Object by the client
     * @param email the email of the user wants to be retrieved
     * @return the userid having this email
     */
    @Override
    @GET
    @Path("findid")
    public int getUserIdByEmail(@QueryParam("email") String email) {
        return getUser(email).getUserId();
    }

    //ex: localhost:8000/user/update {request body containing the updated user}
    /** -------------------------------- PUT --------------------------------
     * PUT-endpoint for updating user
     * request body should contain user object WITH the id
     * @param user the user wants to be updated
     */
    @Override
    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON})
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    //ex: localhost:8000/user/delete/{email}
    /** -------------------------------- DELETE --------------------------------
     * DELETE-endpoint for deleting user
     * @param email the email of the user wants to be deleted
     */
    @Override
    @DELETE
    @Path("delete/{email}")
    public void deleteUser(@PathParam("email") String email) {
        User toBeDeleted = userDAO.getUserByEmail(email);
        userDAO.deleteUserById(toBeDeleted.getUserId());
    }

    //TODO: implement password so it is encrypted
    //ex: localhost:8000/user/verify/{email}/{password}
    /** -------------------------------- GET --------------------------------
     * GET-endpoint for verifying user credential
     * @param email the id of the user wants to be verified
     * @param password the password of the user wants to be verified
     */
    @Override
    @GET
    @Path("/verify/{email}/{password}")
    @Produces({MediaType.TEXT_PLAIN})
    public boolean verifyUser(@PathParam("email") String email, @PathParam("password") String password) {
        User toBeVerified = userDAO.getUserByEmail(email);
        return userDAO.verifyUser(toBeVerified.getUserId(), password);
    }
}
