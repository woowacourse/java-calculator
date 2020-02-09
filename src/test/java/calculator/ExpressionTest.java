package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {
    private Expression expression;

    void setUp_SourceForCalculating(String[] inputs) {
        try {
            expression = new Expression(inputs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void sourceWithTwoOperands_ShouldCalculatePrecisely() {
        String[] inputs = {"1", "+", "2"};
        setUp_SourceForCalculating(inputs);

        double result = expression.calculateInputs();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void sourceWithThreeOperands_ShouldCalculatePrecisely() {
        String[] inputs = {"1", "+", "2", "/", "3"};
        setUp_SourceForCalculating(inputs);

        double result = expression.calculateInputs();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void sourceWithFiveOperands_ShouldCalculatePrecisely() {
        String[] inputs = {"10", "-", "2", "/", "4", "*", "5"};
        setUp_SourceForCalculating(inputs);

        double result = expression.calculateInputs();
        assertThat(result).isEqualTo(10);
    }

    @Test
    void sourceWithOneOperands_ShouldReturnThatOperands() {
        String[] inputs = {"4"};
        setUp_SourceForCalculating(inputs);

        double result = expression.calculateInputs();
        assertThat(result).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 +", "1 / 3 + 4 *", "4 4"})
    void notOddSizeOfInputs_ShouldThrowException(String input) {
        String[] inputs = input.split(" ");
        assertThatThrownBy(() -> {
            expression.validateSizeOfInputsIsOdds(inputs);
        }).isInstanceOf(Exception.class)
                .hasMessageMatching("inputs의 사이즈가 홀수가 아님");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 + 3", "1 / + 4"})
    void notProperTurn_ShouldThrowException(String input) {
        System.out.println(input);
        String[] inputs = input.split(" ");
        assertThatThrownBy(() -> {
            expression.validateSizeOfInputsIsOdds(inputs);
        }).isInstanceOf(Exception.class);
    }
}
