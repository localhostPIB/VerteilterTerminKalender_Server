package terminkalender.exceptions;

public class IntIstNegativException extends RuntimeException{
    private static final String MESSAGE = "Der Integer darf nicht 0 oder negativ sein";

    public IntIstNegativException(){
        super(MESSAGE);
    }
}
