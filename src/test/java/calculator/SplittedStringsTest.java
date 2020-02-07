package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SplittedStringsTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/SpittedString/clusteredStrings.csv", numLinesToSkip = 1)
    void testClustered(String input) {
        Assertions.assertThatThrownBy(()->{
            SplittedStrings sample = new SplittedStrings(input);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageEndingWith("가 연속되면 안됩니다");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SpittedString/stringStartingWithSymbols.csv", numLinesToSkip = 1)
    void testSymbolStarter(String input) {
        Assertions.assertThatThrownBy(()->{
            SplittedStrings sample = new SplittedStrings(input);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("숫자로 시작해야 합니다");
    }
}

