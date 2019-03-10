package terminkalender.dao.classes;

import terminkalender.dao.interfaces.ObjectDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ObjectDAOImpl implements ObjectDAO
{
    static Connection connection;
    EntityManagerFactory factory;
    EntityManager entityManager;
    EntityTransaction transaction;

    /**
     * Standard-konstruktor, erstelle die Verbindung mit dem Datenbank
     */
    public ObjectDAOImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hilfsfunktion, erstelle die persistence entity objekt, um mit dem Datenbank zu kommunizieren
     */
    @Override
    public void initTransaction() {
        factory = Persistence.createEntityManagerFactory("database");
        entityManager = factory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    /**
     * Hilfsfunktion, schliesst die persistence entity objekt aus
     */
    @Override
    public void finishTransaction() {
        entityManager.close();
        factory.close();
    }

}
