package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLOutput;

public class CalculatorTest {
//    private final InputStream systemIn = System.in;
//    //private ByteArrayInputStream testIn;
//
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/SpittedString/clusteredStrings.csv", numLinesToSkip = 1)
//    void testClustered(String input) {
//        Assertions.assertThatThrownBy(()->{
//            //testIn = new ByteArrayInputStream(input.getBytes());
//            System.out.println(input);
//            System.setIn(new ByteArrayInputStream(input.getBytes()));
//            new Calculator();
//            //System.setIn(systemIn);
//        }).isInstanceOf(IllegalArgumentException.class)
//        .hasMessageEndingWith("가 연속되면 안됩니다");
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/SpittedString/stringStartingWithSymbols.csv", numLinesToSkip = 1)
//    void testSymbolStarter(String input) {
//        Assertions.assertThatThrownBy(()->{
//            //testIn = new ByteArrayInputStream(input.getBytes());
//            System.setIn(new ByteArrayInputStream(input.getBytes()));
//            new Calculator();
//        }).isInstanceOf(IllegalArgumentException.class)
//        .hasMessage("숫자로 시작해야 합니다");
//    }

//    Calculator tester = new Calculator();
//    @ParameterizedTest
//    @CsvFileSource(resources = "/calculation.csv", numLinesToSkip = 1)
//    void testCalculator(String input, String expected) {
//        Assertions.assertThat(tester.calculate(input)).isEqualTo(Integer.parseInt(expected));
//    }

}

