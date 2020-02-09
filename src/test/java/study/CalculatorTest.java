package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @BeforeEach
    void setUp() {
        returnValue = TEST_RETURN_VALUE_INIT;
    }

    @Test
    @DisplayName("계산기 전체 동작 확인")
    public static void main(String args[]) {

        String[] values = ExceptionHandlerTest.inputHandler().split(" ");
        returnValue = Double.parseDouble(values[0]);
        for (int i = INDEX_INIT; i < values.length; i++) {
            check(i, values[i]);
        }
        if (returnValue == Math.rint(returnValue)) {
            System.out.println((int) returnValue);
            return;
        }
        System.out.println(returnValue);
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
    @DisplayName("홀수일 경우, 짝우일 경우 계산 확인")
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

    @ParameterizedTest
    @DisplayName("부호에 따른 분류 확인")
    @CsvSource(value = {"5:+:15", "5:-:5", "5:*:50", "5:/:2"}, delimiter = ':')
    void calculateTest(double input, String sign, double expected) {
        nowSign = sign;
        calculate(input);
        assertThat(returnValue).isEqualTo(expected);
    }

    private static void plus(double nowNumber) {
        returnValue += nowNumber;
    }

    @ParameterizedTest
    @DisplayName("덧셈 확인")
    @CsvSource(value = {"5:15", "10:20", "33:43"}, delimiter = ':')
    void plusTest(double input, double expected) {
        plus(input);
        System.out.println(input);
        System.out.println(expected);
        assertThat(returnValue).isEqualTo(expected);
    }

    private static void minus(double nowNumber) {
        returnValue -= nowNumber;
    }

    @ParameterizedTest
    @DisplayName("뺄셈 확인")
    @CsvSource(value = {"5:5", "10:0", "33:-23"}, delimiter = ':')
    void minusTest(double input, double expected) {
        minus(input);
        assertThat(returnValue).isEqualTo(expected);
    }

    private static void multiply(double nowNumber) {
        returnValue *= nowNumber;
    }

    @ParameterizedTest
    @DisplayName("곱셈 확인")
    @CsvSource(value = {"5:50", "10:100", "33:330"}, delimiter = ':')
    void multiplyTest(double input, double expected) {
        multiply(input);
        assertThat(returnValue).isEqualTo(expected);
    }

    private static void divide(double nowNumber) {
        returnValue /= nowNumber;
    }

    @ParameterizedTest
    @DisplayName("나눗셈 확인")
    @CsvSource(value = {"5:2", "10:1", "4:2.5"}, delimiter = ':')
    void divideTest(double input, double expected) {
        divide(input);
        assertThat(returnValue).isEqualTo(expected);
    }
}