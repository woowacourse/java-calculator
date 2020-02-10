package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {
    Calculator tester = new Calculator();

    private static final int NUM_LINES_TO_SKIP = 1;
    private static final String BLANK = " ";

    @ParameterizedTest
    @DisplayName("숫자 혹은 연산자가 연속되는지 테스트")
    @CsvFileSource(resources = "/SpittedString/clusteredStrings.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testClustered(String input) {
        Assertions.assertThatThrownBy(() -> {
            List<String> splittedStrings = Arrays.asList(input.split(BLANK));
            Application.checkClusteredElements(splittedStrings);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageEndingWith("가 연속되면 안됩니다");
    }

    @ParameterizedTest
    @DisplayName("숫자로 시작하는지 테스트")
    @CsvFileSource(resources = "/SpittedString/stringStartingWithSymbols.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testSymbolStarter(String input) {
        Assertions.assertThatThrownBy(() -> {
            List<String> splittedStrings = Arrays.asList(input.split(BLANK));
            Application.checkIfStartWithSymbol(splittedStrings);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자로 시작해야 합니다");
    }

    @ParameterizedTest
    @DisplayName("제대로 된 계산값이 나오는지 테스트")
    @CsvFileSource(resources = "/calculation.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testCalculator(String input, String expected) {
        List<String> splittedStrings = Arrays.asList(input.split(BLANK));
        Assertions.assertThat(tester.calculate(splittedStrings)).isEqualTo(Integer.parseInt(expected));
    }
}

