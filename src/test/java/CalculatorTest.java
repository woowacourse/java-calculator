import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("올바른 숫자를 입력하였는지 검증1")
    @CsvSource(value = {"3 + 0 + 4:true", "1.9 * 6.2:true", "10 + 1 + 4:true",
            "0 / 0:true"}, delimiter = ':')
    void validateDoubleTest1(String input, boolean expected) {
        StringValue stringValue = new StringValue(input);
        stringValue.validateDouble();

        Assertions.assertThat(true).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("올바른 숫자를 입력하였는지 검증2")
    @CsvSource(value = {"( + ! +:false", "*:false", "ans + 문:false"}, delimiter = ':')
    void validateDoubleTest2(String input, boolean expected) {
        Assertions.assertThatThrownBy(() -> {
            StringValue stringValue = new StringValue(input);
            stringValue.validateDouble();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("피연산자가 잘못되었습니다.");

        Assertions.assertThat(false).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("올바른 연산자를 입력하였는지 검증1")
    @CsvSource(value = {"2 * 3 + 4 +:true", "2 - 3:true", "2 * 2 * 2:true"}, delimiter = ':')
    void validateOperatorTest1(String input, boolean expected) {
        StringValue stringValue = new StringValue(input);
        stringValue.validateOperator();

        Assertions.assertThat(true).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("올바른 연산자를 입력하였는지 검증2")
    @CsvSource(value = {"2 a 3:false", ") ):false"}, delimiter = ':')
    void validateOperatorTest2(String input, boolean expected) {
        Assertions.assertThatThrownBy(() -> {
            StringValue stringValue = new StringValue(input);
            stringValue.validateOperator();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("연산자가 잘못되었습니다.");

        Assertions.assertThat(false).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자로 수식이 끝나는 경우 검증1")
    @CsvSource(value = {"2 + 3 * 5 / 2:true", "2 + 3:true", "2 + 3 * 9:true"}, delimiter = ':')
    void validateEndWithOperatorTest1(String input, boolean expected) {
        StringValue stringValue = new StringValue(input);
        stringValue.validateEndWithOperator();

        Assertions.assertThat(true).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자로 수식이 끝나는 경우 검증2")
    @CsvSource(value = {"2 + 3 * 5 / :false", "2 + :false", "2 + 3 * :false"}, delimiter = ':')
    void validateEndWithOperatorTest2(String input, boolean expected) {
        Assertions.assertThatThrownBy(() -> {
            StringValue stringValue = new StringValue(input);
            stringValue.validateEndWithOperator();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("연산자와 숫자가 맞지 않습니다.");

        Assertions.assertThat(false).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자 enum이 올바른지 검증1")
    @CsvSource(value = {"+", "/", "*", " - "})
    void getOperatorByStringTest1(String input) {
        Operator.getOperatorByString(input);
    }

    @ParameterizedTest
    @DisplayName("연산자 enum이 올바른지 검증2")
    @CsvSource(value = {"3", "문자입력", ")"})
    void getOperatorByStringTest2(String input) {
        Assertions.assertThatThrownBy(() -> {
            Operator.getOperatorByString(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("연산자가 잘못되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("연산 결과가 올바른지 검증")
    @CsvSource(value = {"+:1:2:3", "-:2:1:1", "*:7:4:28", "*:2:3:6"}, delimiter = ':')
    void operateTest(String stringOperator, double num1, double num2, double expected) {
        Operator operator = Operator.getOperatorByString(stringOperator);
        double actualResult = operator.operate(num1, num2);

        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("0으로 나눈 경우 검증")
    @CsvSource(value = {"0:0", "1:0", "2:0"}, delimiter = ':')
    void divideByZeroTest(double num1, double num2) {
        Assertions.assertThatThrownBy(() -> {
            Operator operator = Operator.getOperatorByString("/");
            double actualResult = operator.operate(num1, num2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }
}
