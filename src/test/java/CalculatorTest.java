import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("올바른 숫자를 입력하였는지 검증")
    @CsvSource(value = {"3 + ! + 4:false", "1.9 * 6.2:true", "+ + 4:false",
            "5 * 6 * 7 * 9:true", "0 / 0:true"}, delimiter = ':')
    void validateDoubleTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            InputValues inputValues = new InputValues(input);
            inputValues.validateDouble();
        } catch (Exception e) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("올바른 연산자를 입력하였는지 검증")
    @CsvSource(value = {"2 a 3:false", "2 * 3 + 4 +:true", "2 ! 3:false",
            "2 2 2:false", ") ):false"}, delimiter = ':')
    void validateOperatorTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            InputValues inputValues = new InputValues(input);
            inputValues.validateOperator();
        } catch (Exception e) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자로 수식이 끝나는 경우 검증")
    @CsvSource(value = {"2 + 3 * 5 / 2:true", "2 +:false", "2 + 3 *:false"}, delimiter = ':')
    void validateEndWithOperatorTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            InputValues inputValues = new InputValues(input);
            inputValues.validateEndWithOperator();
        } catch (Exception e) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자 enum이 올바른지 검증")
    @CsvSource(value = {"3:false", "+:true", "/:true",
            "문자입력:false", "):false"}, delimiter = ':')
    void getOperatorByStringTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            Operator.getOperatorByString(input);
        } catch (Exception e) {
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
}
