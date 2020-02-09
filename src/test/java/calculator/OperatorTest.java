package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("입력값과 Enum내의 연산자가 잘 매칭되어 있는지, 테스트합니다.")
    public void plus(String input) {
        Operator operator = Operator.of(input);
        assertThat(operator.name()).isEqualTo(Operator.of(input).toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "3,7", "23490,12012", "3.0,5.2"})
    @DisplayName("각 연산자가 수행하는 역할에 문제가 없는지, 테스트")
    public void operate(double left, double right) {
        assertThat(Operator.PLUS.calculate(left, right)).isEqualTo(left + right);
        assertThat(Operator.SUBTRACT.calculate(left, right)).isEqualTo(left - right);
        assertThat(Operator.MULTIPLY.calculate(left, right)).isEqualTo(left * right);
        assertThat(Operator.DIVIDE.calculate(left, right)).isEqualTo(left / right);
    }

    @ParameterizedTest
    @ValueSource(strings = {"=", "#", "$", "!", "@", "%", "^", "&", "ㅁ", "ㄷ", "a"})
    @DisplayName("연산자를 제외한 다른 문자열은 연산자가 아님을 테스트")
    public void isOperator(String input) {
        assertThat(Operator.isOperator(input)).isFalse();
    }
}