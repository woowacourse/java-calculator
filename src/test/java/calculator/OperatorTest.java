package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class OperatorTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/Operator/operate.csv", numLinesToSkip = 1)
    void testOperate(String operator, String arg1, String arg2, String result) {
        Assertions.assertThat(Operator.findOperatorBySymbol(operator).operate(Double.parseDouble(arg1), Double.parseDouble(arg2)))
                .isEqualTo(Double.parseDouble(result));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Operator/invalidSymbols.csv", numLinesToSkip = 1)
    void testInvalidSymbol(String operator, String arg1, String arg2) {
        Assertions.assertThatThrownBy(() -> {
            Operator op = Operator.findOperatorBySymbol(operator);
            op.operate(Double.parseDouble(arg1), Double.parseDouble(arg2));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 연산자입니다.");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Operator/operatorZeroException.csv", numLinesToSkip = 1)
    void testZeroDivider(String operator, String arg1, String arg2) {
        Assertions.assertThatThrownBy(() -> {
            Operator op = Operator.findOperatorBySymbol(operator);
            op.operate(Double.parseDouble(arg1), Double.parseDouble(arg2));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
