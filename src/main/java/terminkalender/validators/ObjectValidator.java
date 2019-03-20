package terminkalender.validators;

import terminkalender.exceptions.ObjectIstNullException;

/**
 * validator class
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
public class ObjectValidator {

    /**
     * check if an object is null
     * @param object the object want to be tested
     * @throws ObjectIstNullException wirft eine Exception, wenn das Objekt null ist
     */
    public static void checkObObjectNullIst(Object object) throws ObjectIstNullException {
        if(object == null){
            throw new ObjectIstNullException();
        }
    }
}
