package terminkalender.dao.classes;

import terminkalender.dao.interfaces.UserDAO;
import terminkalender.model.classes.UserImpl;
import terminkalender.model.interfaces.User;

import javax.persistence.Query;

public class UserDAOImpl extends ObjectDAOImpl implements UserDAO {

    public UserDAOImpl(){
        super();
    }

    @Override
    public int addUser(User user){
        initTransaction();
        transaction.begin();

        entityManager.persist(user);
        transaction.commit();
        int userID = user.getUserId();

        finishTransaction();
        return userID;
    }

    @Override
    public User getUserById(int userId){
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

    @Override
    public User getUserByEmail(String email){
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
    @Override
    public void updateUser(User user){
        initTransaction();
        transaction.begin();

        User updateUser = entityManager.find(UserImpl.class, user.getUserId());
        if(updateUser == null){
            finishTransaction();
            throw new IllegalArgumentException("User existiert nicht!");
        }

        entityManager.merge(user);
        transaction.commit();

        finishTransaction();
    }

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


