package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.domain.Calculator.*;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    static final double TEST_RETURN_VALUE_INIT = 10;
    static double returnValue;
    static String nowSign;

    @BeforeEach
    void setUp() {
        returnValue = TEST_RETURN_VALUE_INIT;
    }

    @ParameterizedTest
    @CsvSource(value = {"1:+:5:10", "2:+:10:20", "4:-:8:2", "6:*:2:20", "8:/:2:5"}, delimiter = ':')
    void checkTest(int i, String sign, String input, double expected) {
        nowSign = sign;
        check(i, input);
        assertThat(returnValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:+:15", "5:-:5", "5:*:50", "5:/:2"}, delimiter = ':')
    void calculateTest(double input, String sign, double expected) {
        nowSign = sign;
        calculate(input);
        assertThat(returnValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:15", "10:20", "33:43"}, delimiter = ':')
    void plusTest(double input, double expected) {
        plus(input);
        System.out.println(input);
        System.out.println(expected);
        assertThat(returnValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:5", "10:0", "33:-23"}, delimiter = ':')
    void minusTest(double input, double expected) {
        minus(input);
        assertThat(returnValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:50", "10:100", "33:330"}, delimiter = ':')
    void multiplyTest(double input, double expected) {
        multiply(input);
        assertThat(returnValue).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:2", "10:1", "4:2.5"}, delimiter = ':')
    void divideTest(double input, double expected) {
        divide(input);
        assertThat(returnValue).isEqualTo(expected);
    }
}