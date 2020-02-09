import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("입력이 올바른지 검증")
    @CsvSource(value = {"1.9 * 6.2:true", "5 * 6 * 7 * 9:true", "0 / 0:true"}
    , delimiter = ':')
    void validateValuesTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            int length = input.split(" ").length;
            InputValues inputValues = new InputValues(input);
            for (int i = 0; i < length; i++) {
                inputValues.validateValues(i);
            }
        } catch (NumberFormatException ne) {
            actualResult = false;
        } catch (IllegalArgumentException ie) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 연산자가 오는 경우 에러메세지 검증")
    @ValueSource(strings = {"3 ! 3 * 3", "3 3 3", "5 ) 9"})
    void validateValuesTest2(String input) {
        Assertions.assertThatThrownBy(() -> {
            int length = input.split(" ").length;
            InputValues inputValues = new InputValues(input);
            for (int i = 0; i < length; i++) {
                inputValues.validateValues(i);
            }
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching(
                "연산자가 잘못되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 피연산자가 오는 경우 에러메세지 검증")
    @ValueSource(strings = {"! * 3 * 3", "a / 3", "5 * * 9"})
    void validateValuesTest3(String input) {
        Assertions.assertThatThrownBy(() -> {
            int length = input.split(" ").length;
            InputValues inputValues = new InputValues(input);
            for (int i = 0; i < length; i++) {
                inputValues.validateValues(i);
            }
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching(
                "피연산자가 잘못되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("연산자로 수식이 끝나는 경우 검증")
    @CsvSource(value = {"2 + 3 * 5 / 2:true", "2 +:false", "2 + 3 *:false"}, delimiter = ':')
    void validateEndWithOperatorTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            int length = input.split(" ").length;
            InputValues inputValues = new InputValues(input);
            inputValues.validateEndWithOperator(length);
        } catch (IllegalArgumentException ie) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자로 수식이 끝나는 경우 에러메세지 검증")
    @ValueSource(strings = {"2 + 3 *", "2 +", "2 + 3 -"})
    void validateEndWithOperatorTest2(String input) {
        Assertions.assertThatThrownBy(() -> {
            int length = input.split(" ").length;
            InputValues inputValues = new InputValues(input);
            inputValues.validateEndWithOperator(length);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching(
                "연산자와 숫자가 맞지 않습니다.");
    }

    @ParameterizedTest
    @DisplayName("연산자 enum 이 올바른지 검증")
    @CsvSource(value = {"3:false", "+:true", "/:true",
            "문자입력:false", "):false"}, delimiter = ':')
    void getOperatorByStringTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            Operator.getOperatorByString(input);
        } catch (IllegalArgumentException e) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
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
    @DisplayName("0으로 나눈 경우 에러메세지 검증")
    @CsvSource(value = {"0:0", "1:0", "2:0"}, delimiter = ':')
    void divideByZeroTest(double num1, double num2) {
        Assertions.assertThatThrownBy(() -> {
            Operator operator = Operator.getOperatorByString("/");
            operator.operate(num1, num2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }
}
