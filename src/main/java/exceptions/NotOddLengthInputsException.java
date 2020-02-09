package exceptions;

public class NotOddLengthInputsException extends IllegalArgumentException {
    private final int length;

    public NotOddLengthInputsException(int length) {
        super(String.format(length + "(length of inputs) is not odd"));
        this.length = length;
    }
}
