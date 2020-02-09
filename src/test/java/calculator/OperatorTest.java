package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class OperatorTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/Operator/calculation.csv", numLinesToSkip = 1)
    void testCalculation(String operator, String arg1, String arg2, String result) {
        Operator tester = Operator.getOperatorByString(operator);
        Assertions.assertThat(tester.apply(Double.parseDouble(arg1), Double.parseDouble(arg2)))
                .isEqualTo(Double.parseDouble(result));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Operator/InvalidSymbols.csv", numLinesToSkip = 1)
    void testInvalidSymbol(String operator, String arg1, String arg2) {
        Assertions.assertThatThrownBy(() -> {
            Operator tester = Operator.getOperatorByString(operator);
            tester.apply(Double.parseDouble(arg1), Double.parseDouble(arg2));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 연산자만 계산 가능합니다");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Operator/OperatorZeroException.csv", numLinesToSkip = 1)
    void testZeroDivider(String operator, String arg1, String arg2) {
        Assertions.assertThatThrownBy(() -> {
            Operator tester = Operator.getOperatorByString(operator);
            tester.apply(Double.parseDouble(arg1), Double.parseDouble(arg2));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
