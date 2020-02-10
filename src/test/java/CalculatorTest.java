import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("올바르게 입력했을 때 테스트")
    @CsvSource(value = {"1 + 2 / 3", "2 * 1", "9 + 1"})
    void validateInputTest(String input) {
       new InputValues(input);
    }

    @ParameterizedTest
    @DisplayName("연산자를 잘못 입력했을 때 테스트")
    @CsvSource(value = {"2 . 3", "1 ' 1"})
    void validateOperatorTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new InputValues(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자가 잘못되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("피연산자를 잘못 입력했을 때 테스트")
    @CsvSource(value = {"a - b", "1 * *"})
    void validateDoubleTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new InputValues(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("피연산자가 잘못되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("연산자로 수식이 끝날 때 테스트")
    @CsvSource(value = {"2 + ", "2 + 3 *"})
    void validateEndWithOperatorTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new InputValues(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자와 숫자가 맞지 않습니다.");
    }

    @ParameterizedTest
    @DisplayName("0으로 나눌 때 테스트")
    @CsvSource(value = {"1 / 0", "0 / 0"})
    void divideByZeroTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            Calculator calculator = new Calculator();
            calculator.calculate(new InputValues(input));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("연산 결과 테스트")
    @CsvSource(value = {"1 * 2 : 2", "1 + 2 * 2 : 6"}, delimiter = ':')
    void getResultTest(String input, double expected) {
        Calculator calculator = new Calculator();
        calculator.calculate(new InputValues(input));
        Assertions.assertThat(calculator.getResult()).isEqualTo(expected);
    }
}
