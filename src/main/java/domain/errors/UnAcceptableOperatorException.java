package domain.errors;

public class UnAcceptableOperatorException extends RuntimeException {
    UnAcceptableOperatorException(String message) {
        super(message);
    }
}
