package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {
    private static GameResult calculator = null;

    /**
     * 기준 값을 0으로 설정하였습니다. (계산 전 초기화 된 값을 의미합니다.)
     */
    @BeforeEach
    public void 계산식에서_첫번째_값을_설정() {
        calculator = new GameResult("3");
    }


    @Test
    public void 더하기_계산이_옳바르게_되는지() throws IllegalAccessException {
        calculator.resultCalculator("+", "3");
        assertThat(calculator.getFinalResult()).isEqualTo(6);
    }

    @Test
    public void 빼기_계산이_옳바르게_되는지() throws IllegalAccessException {
        calculator.resultCalculator("-", "3");
        assertThat(calculator.getFinalResult()).isEqualTo(0);
    }

    @Test
    public void 곱셈_계산이_옳바르게_되는지() throws IllegalAccessException {
        calculator.resultCalculator("*", "3");
        assertThat(calculator.getFinalResult()).isEqualTo(9);
    }

    @Test
    public void 나눗셈_계산이_옳바르게_되는지() throws IllegalAccessException {
        calculator.resultCalculator("/", "3");
        assertThat(calculator.getFinalResult()).isEqualTo(1);
    }

    @Test
    public void 나누기0이_예외를_뱉어내는지() throws IllegalAccessException {
        assertThatThrownBy(() -> {
            calculator.resultCalculator("/", "0");
        }).isInstanceOf(ArithmeticException.class);
    }


}