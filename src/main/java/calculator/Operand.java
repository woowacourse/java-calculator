package calculator;

public class Operand {
    private int value;

    public Operand(String input) {
        value = Integer.parseInt(input);
    }

    public int getValue() {
        return value;
    }
}
