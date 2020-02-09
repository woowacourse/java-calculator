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
        tester.calculate(givenSample);
        Assertions.assertThat(tester.getResult()).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculation.csv", numLinesToSkip = 1)
    void testCalculator(String input, String expected) {
        tester.calculate(input);
        Assertions.assertThat(tester.getResult()).isEqualTo(Double.parseDouble(expected));
    }
}