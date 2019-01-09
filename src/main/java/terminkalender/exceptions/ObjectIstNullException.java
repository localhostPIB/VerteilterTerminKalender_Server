package terminkalender.exceptions;

public class ObjectIstNullException extends RuntimeException {
    private static String Message ="Das Objekt darf nicht null sein";

    public ObjectIstNullException(){
        super(Message);
    }
}
