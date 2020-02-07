package view;

public class StringSpliter {
    private final static String SPACE = " ";

    public static String[] split(String input) {
        return input.split(SPACE);
    }
}
