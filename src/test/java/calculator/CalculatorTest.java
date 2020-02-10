package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.domain.Calculator.*;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    static final double TEST_RETURN_VALUE_INIT = 10;
    static final String TEST_NOW_SIGN_INIT = "+";
    Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        calculator.setReturnValue(TEST_RETURN_VALUE_INIT);
        calculator.setNowSign(TEST_NOW_SIGN_INIT);
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                Arguments.of(new String[]{"4", "*", "3", "/", "5", "-", "20"}, -17.6),
                Arguments.of(new String[]{"2", "-", "1", "*", "3", "+", "2"}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("stringArrayProvider")
    @DisplayName("문자열을 받아 계산하는 메서드")
    void selectOddNumberOrEvenNumberTest(String[] values, double expected) {
        calculator.setReturnValue(Double.parseDouble(values[0]));
        selectOddNumberOrEvenNumber(values);
        assertThat(calculator.getReturnValue()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:-:+", "1:*:*", "3:-:-"}, delimiter = ':')
    @DisplayName("인덱스가 홀수면 부호를 저장하는 메서드")
    void calculateOddNumberTest(int index, String value, String expected) {
        calculator.calculateOddNumber(index, value);
        assertThat(calculator.getNowSign()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1:11", "2:2.3:12.3", "3:4.0:10"}, delimiter = ':')
    @DisplayName("인덱스가 짝수면 계산하는 메서드")
    void calculateEvenNumberTest(int index, String value, double expected) {
        calculator.calculateEvenNumber(index, value);
        assertThat(calculator.getReturnValue()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:11", "2.3:12.3", "4.0:14.0"}, delimiter = ':')
    @DisplayName("연산자에 따라 계산하는 메서드")
    void selectOperatorsTest(double value, double expected) {
        calculator.selectOperators(value);
        assertThat(calculator.getReturnValue()).isEqualTo(expected);
    }
}