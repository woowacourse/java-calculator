package calculator;

import domain.Calculator;
import domain.Formulas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @DisplayName("validation 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2, 3"
            , "2 + 3 * 4 / 2, 10"
            , "1000 _ 1000, 0"
            , "100 + + 1, 1001"
            , "100000000000000000000000000000000000 - 1, 9999"
            , "+10 - -10, 20"
            , "100 + 10.0.0, 110"
            , "100 / 0, 1"
            , "100  + 10, 110"
            , "100     +    10, 110"
    })
    void calculateParameterTest(String formula, int expected) {
        try {
            int result = new Calculator(new Formulas(formula)).stringCalculate();
            assertThat(result).isEqualTo(expected);
        } catch (IllegalArgumentException iae) {
            assertThat(iae.getClass()).isEqualTo(IllegalArgumentException.class);
        }
    }
}
