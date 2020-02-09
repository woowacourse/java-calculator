package calculator;

import domain.Calculator;
import domain.Formulas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @DisplayName("validation 테스트 - 성공편")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2, 3"
            , "2 + 3 * 4 / 2, 10"
            , "+10 - -10, 20"
            , "100  + 10, 110"
            , "100     +    10, 110"
    })
    void calculateTest(String formula, int expected) {
        int result = new Calculator(new Formulas(formula)).stringCalculate();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("validation 테스트 - 예외편")
    @ParameterizedTest
    @CsvSource(value = {"1000 _ 1000, 올바른 연산자를 입력하지 않으셨습니다."
            , "100 + + 1, 숫자가 아닙니다."
            , "100000000000000000000000000000000000 - 1, 계산할 수 있는 범위(Int)를 넘어섰습니다."
            , "100 + 10.0.0, 숫자가 아닙니다."
            , "100 / 0, 0으로 나눌 수 없습니다."
    })
    void calculateTestException(String formula, String expected) {
        assertThatThrownBy(() ->
                new Calculator(new Formulas(formula)).stringCalculate()
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }
}
