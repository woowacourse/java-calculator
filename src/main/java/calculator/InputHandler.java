package calculator;

public class InputHandler {
    private static final String delimiterToSplit = " ";

    public static String[] splitInput(String input) {
        return input.split(delimiterToSplit);
    }
}
