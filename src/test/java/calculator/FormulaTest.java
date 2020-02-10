package calculator;

import exceptions.InvalidOperatorException;
import exceptions.NotOddLengthInputsException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class FormulaTest {
    private Formula formula;

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 +", "1 / 3 + 4 *", "4 4"})
    void notOddSizeOfInputs_ShouldThrowException(String input) {
        String[] inputs = input.split(" ");
        assertThatThrownBy(() -> formula = new Formula(inputs))
                .isInstanceOf(NotOddLengthInputsException.class)
                .hasMessageMatching("\\d+\\(length of inputs\\) is not odd");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 j 2", "1 ^ 3 + 4", "4 3 4"})
    void nonOperatorInEvenIndex_ShouldThrowException(String input) {
        String[] inputs = input.split(" ");
        assertThatThrownBy(() -> formula = new Formula(inputs))
                .isInstanceOf(InvalidOperatorException.class)
                .hasMessageMatching(".+ is not valid operator\nOnly \\+, -, \\*, / is permitted");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+ 1 2", "1 + as + 4", "4 + *"})
    void nonOperandInOddIndex_ShouldThrowException(String input) {
        String[] inputs = input.split(" ");
        assertThatThrownBy(() -> formula = new Formula(inputs))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageMatching("For input string: \".+\"");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 / 3:1", "3 + 4 + 5:12", "5.5 - 1.5 / 2:2", "3 * 6:18"}, delimiter = ':')
    void calculateFormula_ShouldCalculateProperly(String input, double expected) {
        String[] inputs = input.split(" ");
        formula = new Formula(inputs);
        assertThat(Calculator.calculateFormula(formula)).isEqualTo(expected);
    }
}
