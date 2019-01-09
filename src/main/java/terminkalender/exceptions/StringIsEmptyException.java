package terminkalender.exceptions;

public class StringIsEmptyException extends RuntimeException {
    private static final String MESSAGE = "Der String darf nicht leer sein!";

    public StringIsEmptyException() {
        super(MESSAGE);
    }
}
