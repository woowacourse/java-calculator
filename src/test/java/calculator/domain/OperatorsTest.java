package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorsTest {
    @DisplayName("Enum의 valueOf()에 대한 학습 테스트")
    @Test
    void valueOf() {
        String symbol = "PLUS";
        Assertions.assertThat(Operators.valueOf(symbol)).isEqualTo(Operators.PLUS);
    }

    @DisplayName("각 연산자의 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"PLUS, 4, 2, 6", "MINUS, 4, 2, 2", "MULTIPLY, 4, 2, 8", "DIVIDE, 4, 2, 2"})
    void operate(Operators operator, int a, int b, int expectedResult) {
        int result = operator.operate(a, b);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("예외 케이스 테스트: 0으로 나누기 연산을 시도하는 경우")
    @Test
    void divideByZero() {
        assertThatThrownBy(() -> Operators.DIVIDE.operate(1, 0))
                .isInstanceOf(ArithmeticException.class);
    }

    @DisplayName("입력받은 연산자와 연산자 Enum 기호 일치 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"PLUS,+,true", "MINUS,-,true", "MULTIPLY,*,true", "DIVIDE,/,true", "PLUS,-,false"})
    void hasThis(Operators operator, String symbol, boolean expectedResult) {
        assertThat(operator.hasThis(symbol)).isEqualTo(expectedResult);
    }

    @DisplayName("입력받은 연산자로 연산자 Enum 찾기")
    @ParameterizedTest
    @CsvSource(value = {"+, PLUS", "-, MINUS", "*, MULTIPLY", "/, DIVIDE"})
    void findOperator(String symbol, Operators operator) {
        assertThat(Operators.findOperator(symbol)).isEqualTo(operator);
    }

    @DisplayName("예외 케이스 테스트: 지원하지 않는 연산자가 입력된 경우")
    @Test
    void notSupportedOperator() {
        String notSupportedOperator = "%";
        assertThatThrownBy(() -> Operators.findOperator(notSupportedOperator))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining("해당 연산자 없음");
    }
}
