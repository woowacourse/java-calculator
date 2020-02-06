package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator tester = new Calculator();

    @Test
    void testGivenString() {
        String givenSample = "2 + 3 * 4 / 2";
        Assertions.assertThat(tester.calculate(givenSample)).isEqualTo(10);
    }
}
