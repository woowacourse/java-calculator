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
        .hasMessageStartingWith("there exist clustered");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SpittedString/stringStartingWithSymbols.csv", numLinesToSkip = 1)
    void testSymbolStarter(String input) {
        Assertions.assertThatThrownBy(()->{
            SplittedStrings sample = new SplittedStrings(input);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("given mathematical expression starts with symbol");
    }
}

