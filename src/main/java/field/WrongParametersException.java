package field;

public class WrongParametersException extends RuntimeException {
    private static final String ExceptionMessage = "Wrong parameters";

    public WrongParametersException() {
        super(ExceptionMessage);
    }
}
