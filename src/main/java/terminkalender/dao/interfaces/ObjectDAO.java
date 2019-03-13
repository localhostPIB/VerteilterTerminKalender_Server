package terminkalender.dao.interfaces;

/**
 * Interface for the ObjectDAO, the superclass for all DAO Classes
 */
public interface ObjectDAO
{
    //create the persistence entity object, so the DAO can communicate with the database
    void initTransaction();

    //close the connection to the database
    void finishTransaction();
}
