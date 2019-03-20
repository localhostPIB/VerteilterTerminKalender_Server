package terminkalender.dao.classes;

import terminkalender.dao.interfaces.UserDAO;
import terminkalender.model.classes.UserImpl;
import terminkalender.model.interfaces.User;

import javax.persistence.Query;

/**
 * DAO-Class for the UserDAO
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public class UserDAOImpl extends ObjectDAOImpl implements UserDAO
{
    /**
     * constructor, call the ObjectDAO constructor
     * to initialize connection to database
     */
    public UserDAOImpl(){
        super();
    }

    /** ------------- ADD -------------
     * add new User to the database
     * @param user the user - Object
     * @return the id of the newly stored user
     */
    @Override
    public int addUser(User user) {
        initTransaction();
        transaction.begin();

        entityManager.persist(user);
        transaction.commit();
        int userID = user.getUserId();

        finishTransaction();
        return userID;
    }

    /** ------------- GET 1 -------------
     * find the User - Object based on its id
     * @param userId the id of the user
     * @return the User - Object
     */
    @Override
    public User getUserById(int userId) {
        initTransaction();
        transaction.begin();

        User user = entityManager.find(UserImpl.class, userId);
        if(user == null) {
            finishTransaction();
            throw new IllegalArgumentException("User existiert nicht!");
        }

        finishTransaction();
        return user;
    }

    /** ------------- GET 1 -------------
     * find the User - Object based on its email
     * @param email the email of the user
     * @return the User - Object
     */
    @Override
    public User getUserByEmail(String email) {
        initTransaction();
        transaction.begin();

        User user = entityManager
                        .createQuery("SELECT u FROM UserImpl u where u.email = :email", User.class)
                        .setParameter("email", email)
                        .getSingleResult();
        if(user == null) {
            finishTransaction();
            throw new IllegalArgumentException("User existiert nicht!");
        }

        finishTransaction();
        return user;
    }

    /** ------------- UPDATE -------------
     * update the user in the database
     * @param user the updated event
     */
    @Override
    public void updateUser(User user) {
        initTransaction();
        transaction.begin();

        User updateUser = entityManager.find(UserImpl.class, user.getUserId());
        if(updateUser == null) {
            finishTransaction();
            throw new IllegalArgumentException("User existiert nicht!");
        }

        entityManager.merge(user);
        transaction.commit();
        finishTransaction();
    }

    /** ------------- DELETE 1 -------------
     * delete user from the database
     * @param userId id of the to be deleted user
     */
    @Override
    public void deleteUserById(int userId) {
        initTransaction();
        transaction.begin();

        User user = entityManager.find(UserImpl.class, userId);
        if(user == null) {
            finishTransaction();
            throw new IllegalArgumentException("User existiert nicht!");
        }

        entityManager.remove(user);
        transaction.commit();
        finishTransaction();
    }

    /** ------------- VERIFY -------------
     * verify user from the with its password
     * @param userId id of the user
     * @param password password of the user
     */
    @Override
    public boolean verifyUser(int userId, String password) {
        initTransaction();
        transaction.begin();

        User user = entityManager.find(UserImpl.class, userId);
        if(user == null) {
            finishTransaction();
            throw new IllegalArgumentException("User existiert nicht!");
        }

        finishTransaction();
        return user.getPassword().equals(password);
    }

    /**
     * DELETE ALL RECORDS FROM USER TABLE
     */
    @Override
    public void removeAllUserData() {
        initTransaction();
        transaction.begin();

        entityManager
                .createQuery("DELETE FROM UserImpl")
                .executeUpdate();
        transaction.commit();

        finishTransaction();
    }
}


