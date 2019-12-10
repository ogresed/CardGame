package game.field;

class WrongParametersException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "Wrong parameters";

    WrongParametersException() {
        super(EXCEPTION_MESSAGE);
    }
}
