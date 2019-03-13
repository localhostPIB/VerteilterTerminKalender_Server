package terminkalender.dao.classes;

import terminkalender.dao.interfaces.ObjectDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * superclass of all DAO-Classes
 */
public class ObjectDAOImpl implements ObjectDAO
{
    private static Connection connection;
    private EntityManagerFactory factory;
    EntityManager entityManager;
    EntityTransaction transaction;

    /**
     * Standard constructor, connect to the database
     */
    ObjectDAOImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * create the persistence entity object, so the DAO can communicate with the database
     */
    @Override
    public void initTransaction() {
        factory = Persistence.createEntityManagerFactory("database");
        entityManager = factory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    /**
     * close the connection to the database
     */
    @Override
    public void finishTransaction() {
        entityManager.close();
        factory.close();
    }
}
