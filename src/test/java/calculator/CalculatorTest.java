package calculator;

import domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @DisplayName("계산식 분할 테스트")
    @Test
    void splitFormula() {
        String formula = "3 + 2 - 1";
        double[] numbers = {3, 2, 1};
        char[] operators = {'+', '-'};

        calculator.splitFormula(formula);

        double[] targetNumbers = calculator.getNumbers().stream().mapToDouble(Double::doubleValue).toArray();
        Assertions.assertThat(numbers).isEqualTo(targetNumbers);

        char[] targetOperators = new char[calculator.getOperators().size()];
        for (int i = 0; i < calculator.getOperators().size(); i++) {
            targetOperators[i] = calculator.getOperators().get(i);
        }
        Assertions.assertThat(operators).isEqualTo(targetOperators);
    }

    @DisplayName("컬랙션 분할 후 계산 테스트")
    @Test
    public void calculate() {
        String formula = "3 + 2 - 1";
        calculator.splitFormula(formula);

        double result = calculator.calculate();
        Assertions.assertThat(result).isEqualTo(4);
    }
}
