package terminkalender.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import terminkalender.dao.interfaces.UserDAO;
import terminkalender.model.interfaces.User;
import terminkalender.service.interfaces.UserService;
import terminkalender.service.RepositoriesInterface.UserRepository;

@RestController
@RequestMapping("/user")
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    private UserRepository userRepository;

    /*@POST
    @Path("{addUser}")
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public int addUser(@PathParam("addUser") int userId){
        return 0;
    }*/


    /*@GET
    @Path("{userid}")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public Response getUser(@QueryParam("userid") int userId) {
        Response response;
        System.out.println("Request: " + userId);
        JSONArray result = new JSONArray();
        JSONObject jsonObject =  new JSONObject();

        try {
            User user = userDAO.getUser(userId);

            jsonObject.put("UserId", user.getUserId());
            jsonObject.put("Name ", user.getName());
            jsonObject.put("LastName", user.getLastName());
            jsonObject.put("Email", user.getEmail());
            result.put(jsonObject);
            response = Response.status(200).entity(result.toString()).build();
        } catch (IllegalArgumentException e){
            jsonObject.put("Message", e);
            result.put(jsonObject);
            response = Response.status(404).entity(result.toString()).build();
        }
        return response;
    }*/

    @PostMapping
    @Override
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //TODO password might be included

    @GetMapping(path = {"/{userid}"})
    @Override
    public ResponseEntity<User> getUser(@PathVariable long userid){
        return userRepository.findById(userid)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    /*@PUT
    @Path("{userid}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Override
    public void updateUser(@PathParam("userid") int userId){

    }*/

    @Override
    @PutMapping(value="/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") long userId,
                                           @RequestBody User user){
        return userRepository.findById(userId)
                .map(record -> {
                    record.setName(user.getName());
                    record.setEmail(user.getEmail());
                    record.setLastName(user.getLastName());
                    record.setPassword(user.getPassword());
                    User updated = userRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    /*@DELETE
    @Override
    public void deleteUser( int userId){

    }*/

    @Override
    @DeleteMapping(path ={"/{userId}"})
    public ResponseEntity<?> deleteUser(@PathVariable("userId") long userId) {
        return userRepository.findById(userId)
                .map(record -> {
                    userRepository.deleteById(userId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public boolean verifyUser(String password){
        return true;
    }
}
