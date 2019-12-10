package field;

public class WrongParametersException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "Wrong parameters";

    public WrongParametersException() {
        super(EXCEPTION_MESSAGE);
    }
}
