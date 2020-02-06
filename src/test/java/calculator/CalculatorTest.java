package calculator;

import domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator controller = new Calculator();
    String formula;

    @BeforeAll
    void setUp() {
        formula = "3 + 2 - 1";
    }

    @DisplayName("계산식 분할 테스트")
    @Test
    void splitFormula() {
        double[] numbers = {3, 2, 1};
        char[] operators = {'+', '-'};

        controller.splitFormula(formula);

        double[] targetNumbers = controller.getNumbers().stream().mapToDouble(Double::doubleValue).toArray();
        Assertions.assertThat(numbers).isEqualTo(targetNumbers);

        char[] targetOperators = new char[controller.getOperators().size()];
        for (int i = 0; i < controller.getOperators().size(); i++) {
            targetOperators[i] = controller.getOperators().get(i);
        }
        Assertions.assertThat(operators).isEqualTo(targetOperators);
    }

    @DisplayName("컬랙션 분할 후 계산 테스트")
    @Test
    public void runCalculator() {

    }
}
