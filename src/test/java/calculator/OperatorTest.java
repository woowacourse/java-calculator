package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    static final double TEST_RETURN_VALUE_INIT = 10;
    static final double TEST_NOW_NUMBER = 5;
    private Operator plusOperator;
    private Operator minusOperator;
    private Operator multiplyOperator;
    private Operator divideOperator;

    @BeforeEach
    void setUp() {
        plusOperator = Operator.PLUS;
        minusOperator = Operator.MINUS;
        multiplyOperator = Operator.MULTIPLY;
        divideOperator = Operator.DIVIDE;
    }

    @Test
    @DisplayName("더하기 연산자 메서드 테스트")
    void plusOperatorTest() {
        assertThat(plusOperator.calculate(TEST_NOW_NUMBER, TEST_RETURN_VALUE_INIT)).isEqualTo(TEST_RETURN_VALUE_INIT + TEST_NOW_NUMBER);
    }

    @Test
    @DisplayName("빼기 연산자 메서드 테스트")
    void minusOperatorTest() {
        assertThat(minusOperator.calculate(TEST_NOW_NUMBER, TEST_RETURN_VALUE_INIT)).isEqualTo(TEST_RETURN_VALUE_INIT - TEST_NOW_NUMBER);
    }

    @Test
    @DisplayName("곱하기 연산자 메서드 테스트")
    void multiplyOperatorTest() {
        assertThat(multiplyOperator.calculate(TEST_NOW_NUMBER, TEST_RETURN_VALUE_INIT)).isEqualTo(TEST_RETURN_VALUE_INIT * TEST_NOW_NUMBER);
    }

    @Test
    @DisplayName("나누기 연산자 메서드 테스트")
    void divideOperatorTest() {
        assertThat(divideOperator.calculate(TEST_NOW_NUMBER, TEST_RETURN_VALUE_INIT)).isEqualTo(TEST_RETURN_VALUE_INIT / TEST_NOW_NUMBER);
    }

}
