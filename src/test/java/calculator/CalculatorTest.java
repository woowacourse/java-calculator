package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void calculate() {
        final String INPUT_EXPECTED_DELIMITER = "expected:";
        String[] testcases = {
            "1 + 3 * 5 - 2" + INPUT_EXPECTED_DELIMITER + "18",
            "+5 + -2" + INPUT_EXPECTED_DELIMITER + "3"
        };

        for (String testcase : testcases) {
            String[] inputAndExpected = testcase.split(INPUT_EXPECTED_DELIMITER);
            Expression expression = new Expression(inputAndExpected[0]);
            Assertions.assertThat(Calculator.calculate(expression))
                    .isEqualTo(Double.parseDouble(inputAndExpected[1]));
        }
    }
}
