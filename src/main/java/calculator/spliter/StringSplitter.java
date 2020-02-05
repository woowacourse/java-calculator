package calculator.spliter;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private static final String BLANK = " ";

    public static List<String> stringSplitter(String inputString) {
        return Arrays.asList(inputString.split(BLANK));
    }
}