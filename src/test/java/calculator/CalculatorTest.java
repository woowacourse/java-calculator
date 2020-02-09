package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatorTest {
    Calculator tester = new Calculator();

    private static final int NUM_LINES_TO_SKIP = 1;

    @ParameterizedTest
    @CsvFileSource(resources = "/SpittedString/clusteredStrings.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testClustered(String input) {
        Assertions.assertThatThrownBy(() -> {
            tester.setSplittedStrings(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageEndingWith("가 연속되면 안됩니다");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SpittedString/stringStartingWithSymbols.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testSymbolStarter(String input) {
        Assertions.assertThatThrownBy(() -> {
            tester.setSplittedStrings(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자로 시작해야 합니다");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculation.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testCalculator(String input, String expected) {
        tester.setSplittedStrings(input);
        Assertions.assertThat(tester.calculate()).isEqualTo(Integer.parseInt(expected));
    }
}

