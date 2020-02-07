import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("실수형 검증")
    @CsvSource(value = {"3:true", "1.9:true", "문자 입력:false",
            "+:false", "-1:true"}, delimiter = ':')
    void validateDoubleTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            Validator.validateDouble(input);
        } catch (Exception e) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자 검증")
    @CsvSource(value = {"3:false", "+:true", "/:true",
            "문자입력:false", "):false"}, delimiter = ':')
    void validateOperatorTest(String input, boolean expected) {
        boolean actualResult = true;
        try {
            Validator.validateOperator(input);
        } catch (Exception e) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산자 enum 검증")
    @CsvSource(value = {"3:false", "+:true", "/:true",
            "문자입력:false", "):false"}, delimiter = ':')
    void getOperatorByStringTest(String input, boolean expected){
        boolean actualResult = true;
        try {
            Operator.getOperatorByString(input);
        } catch (Exception e) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("연산 결과 검증")
    @CsvSource(value = {"+:1:2:3", "-:2:1:1", "/:1:0:0", "*:2:3:6"}, delimiter =':')
    void operateTest(String stringOperator, double num1, double num2, double expected){
        Operator operator = Operator.getOperatorByString(stringOperator);
        double actualResult = operator.operate(num1, num2);

        Assertions.assertThat(actualResult).isEqualTo(expected);
    }
}
