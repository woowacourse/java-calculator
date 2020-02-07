package calculator;

import domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @DisplayName("계산식 분할 테스트")
    @Test
    void splitFormula() {
        String formula = "3 + 2 / 1";
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
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3,6", "3 * 6 + 3,21", "3 * 3 / 3,3", "3 + 2 - 5,0"})
    public void calculate(String formula, double expect) {
        calculator.splitFormula(formula);

        double result = calculator.calculate();
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @DisplayName("종료 상황 테스트")
    @Test
    void SendErrorMessage() {
        String value = "프로그램을 종료합니다.\r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String string = "1 + 3 / 0";
        InputStream in = new ByteArrayInputStream(string.getBytes());
        System.setIn(in);
        calculator.run();

        Assertions.assertThat(outContent.toString()).isEqualTo(value);
    }
}
