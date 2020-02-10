package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("입력된 수식의 값이 예상대로 계산되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"5 + 3 / 2:4", "3 * 4 - 2:10", "6 + 7 * 2:26"}, delimiter = ':')
    void testCalculate(String input, String expectedResult) {
        double actual = Calculator.calculate(new Expression(input));
        double expected = Double.parseDouble(expectedResult);
        assertThat(actual).isEqualTo(expected);
    }

}
