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
 * Resource class for User-Object
 */
@Path(UserServiceImpl.webContextPath)
public class UserServiceImpl implements UserService
{

    private UserDAO userDAO;
    static final String webContextPath ="user";

    private UserServiceImpl(UserDAO userDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(userDAO);
        this.userDAO = userDAO;
    }

    public UserServiceImpl() throws ObjectIstNullException {
        this(DAOObjectBuilder.getUserDaoObject());
    }

    //ex: localhost:8000/user/add {request body containing the new user}
    /**
     * POST-endpoint for adding new user
     * request body should contain user object WITHOUT the id
     * @param user the new user to be added
     * @return the new user after stored in the database and given id
     */
    @Override
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user) {
        int newUserId = userDAO.addUser(user);
        return userDAO.getUser(newUserId);
    }

    //ex: localhost:8000/user/{email}
    /**
     * GET-endpoint for retrieving user
     * @param email the id of the user wants to be retrieved
     * @return the user having the userId
     */
    @Override
    @GET
    @Path("{email}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getUser(@PathParam("email") String email) {
        return userDAO.getEmail(email);
    }

    //ex: localhost:8000/user/update {request body containing the updated user}
    /**
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

    //ex: localhost:8000/user/delete/23
    /**
     * DELETE-endpoint for deleting user
     * @param userId the id of the user wants to be deleted
     */
    @Override
    @DELETE
    @Path("delete/{userid}")
    public void deleteUser(@PathParam("userid") int userId) {
        userDAO.deleteUser((int)userId);
    }

    //TODO: implement password so it is encrypted
    //ex: localhost:8000/user/verify/25/h
    /**
     * GET-endpoint for verifying user credential
     * @param userId the id of the user wants to be deleted
     * @param password the password of the user wants to be checked
     */
    @Override
    @GET
    @Path("/verify/{userid}/{password}")
    @Produces({MediaType.TEXT_PLAIN})
    public boolean verifyUser(@PathParam("userid")int userId, @PathParam("password")String password){
        return userDAO.verifyUser(userId, password);
    }





//    @PostMapping
//    @Override
//    public User addUser(@RequestBody User user){
//        return userRepository.save(user);
//    }
//
//    //TODO password might be included
//
//    @GetMapping(path = {"/{userid}"})
//    @Override
//    public ResponseEntity<User> getUser(@PathVariable long userid){
//        return userRepository.findById(userid)
//                .map(record -> ResponseEntity.ok().body(record))
//                .orElse(ResponseEntity.notFound().build());
//    }




//    @Override
//    @PutMapping(value="/{userId}")
//    public ResponseEntity<User> updateUser(@PathVariable("userId") long userId,
//                                           @RequestBody User user){
//        return userRepository.findById(userId)
//                .map(record -> {
//                    record.setName(user.getName());
//                    record.setEmail(user.getEmail());
//                    record.setLastName(user.getLastName());
//                    record.setPassword(user.getPassword());
//                    User updated = userRepository.save(record);
//                    return ResponseEntity.ok().body(updated);
//                }).orElse(ResponseEntity.notFound().build());
//    }

//    @Override
//    @DeleteMapping(path ={"/{userId}"})
//    public ResponseEntity<?> deleteUser(@PathVariable("userId") long userId) {
//        return userRepository.findById(userId)
//                .map(record -> {
//                    userRepository.deleteById(userId);
//                    return ResponseEntity.ok().build();
//                }).orElse(ResponseEntity.notFound().build());
//    }
//
//    @Override
//
}
