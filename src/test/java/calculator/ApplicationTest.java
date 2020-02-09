package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

public class ApplicationTest {
    Calculator tester = new Calculator();

    @Test
    void testGivenString() {
        String givenSample = "2 + 3 * 4 / 2";
        tester.splitMathExpression(givenSample);
        Assertions.assertThat(tester.calculate()).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculation.csv", numLinesToSkip = 1)
    void testCalculator(String input, String expected) {
        tester.splitMathExpression(input);
        Assertions.assertThat(tester.calculate()).isEqualTo(Integer.parseInt(expected));
    }
}