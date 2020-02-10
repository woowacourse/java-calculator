package exceptions;

public class InvalidOperatorException extends IllegalArgumentException {
    private final String invalidOperator;

    public InvalidOperatorException(String invalidOperator) {
        super(String.format(invalidOperator + " is not valid operator\nOnly +, -, *, / is permitted"));
        this.invalidOperator = invalidOperator;
    }
}
