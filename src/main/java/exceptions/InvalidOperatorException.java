package exceptions;

public class InvalidOperatorException extends IllegalArgumentException {
    private final String invalidOperator;

    public InvalidOperatorException(String invalidOperator) {
        super(String.format(invalidOperator + " is not valid operator"));
        this.invalidOperator = invalidOperator;
    }
}
