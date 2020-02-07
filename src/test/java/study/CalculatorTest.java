package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private static final double TEST_RETURN_VALUE_INIT = 10;
    private static final int INDEX_INIT = 1;
    private static final int EVEN = 0;
    private static final int ODD = 1;
    static double returnValue;
    static String nowSign;

    @Test
    public static void main(String args[]) {
        String[] values = ExceptionHandlerTest.inputHandler().split(" ");
        returnValue = Double.parseDouble(values[0]);
        for (int i = INDEX_INIT; i < values.length; i++) {
            check(i, values[i]);
        }
        if(returnValue == (int) returnValue){
            System.out.println((int) returnValue);
            return;
        }
        System.out.println(returnValue);
    }

    @BeforeEach
    void setUp() {
        returnValue = TEST_RETURN_VALUE_INIT;
    }

    private static void check(int i, String value) {
        if (i % 2 == EVEN) {
            calculate(Double.parseDouble(value));
        }
        if (i % 2 == ODD) {
            nowSign = value;
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1:+:5:10", "2:+:10:20", "4:-:8:2", "6:*:2:20", "8:/:2:5"}, delimiter = ':')
    void checkTest(int i, String sign, String input, double expected) {
        nowSign = sign;
        check(i, input);
        assertThat(returnValue).isEqualTo(expected);
    }

    private static void calculate(double nowNumber) {
        if (nowSign.equals("+")) {
            plus(nowNumber);
            return;
        }
        if (nowSign.equals("-")) {
            minus(nowNumber);
            return;
        }
        if (nowSign.equals("*")) {
            multiply(nowNumber);
            return;
        }
        if (nowSign.equals("/")) {
            divide(nowNumber);
            return;
        }
    }

    private static void plus(double nowNumber) {
        returnValue += nowNumber;
    }

    private static void minus(double nowNumber) {
        returnValue -= nowNumber;
    }

    private static void multiply(double nowNumber) {
        returnValue *= nowNumber;
    }

    private static void divide(double nowNumber) {
        returnValue /= nowNumber;
    }
}