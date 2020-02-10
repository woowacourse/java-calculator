package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {
    private static GameResult calculator = null;

    /**
     * 기준 값을 3으로 설정하였습니다. (계산 전 초기화 된 값을 의미합니다.)
     */

    @DisplayName("계산식에서 첫번째 값을 설정")
    @BeforeEach
    public void initializeCalculator() {
        calculator = new GameResult("3");
    }

    @DisplayName("더하기 계산이 올바르게 되는지 확인")
    @Test
    public void testAdd() throws IllegalAccessException {
        calculator.resultCalculator("+", "3");
        assertThat(calculator.getFinalResult()).isEqualTo(6);
    }

    @DisplayName("빼기 계산이 올바르게 되는지 확인")
    @Test
    public void testSubtract() throws IllegalAccessException {
        calculator.resultCalculator("-", "3");
        assertThat(calculator.getFinalResult()).isEqualTo(0);
    }

    @DisplayName("곱하기 계산이 올바르게 되는지 확인")
    @Test
    public void testMultiply() throws IllegalAccessException {
        calculator.resultCalculator("*", "3");
        assertThat(calculator.getFinalResult()).isEqualTo(9);
    }

    @DisplayName("나누기 계산이 올바르게 되는지 확인")
    @Test
    public void testDivide() throws IllegalAccessException {
        calculator.resultCalculator("/", "3");
        assertThat(calculator.getFinalResult()).isEqualTo(1);
    }

    @DisplayName("나누기 0 계산이 예외를 올바르게 뱉어내는지 확인")
    @Test
    public void testDivideZero() throws IllegalAccessException {
        assertThatThrownBy(() -> {
            calculator.resultCalculator("/", "0");
        }).isInstanceOf(ArithmeticException.class);
    }


}