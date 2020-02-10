package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class OperatorTest {
    private static final int NUM_LINES_TO_SKIP = 1;

    @ParameterizedTest
    @DisplayName("연산자가 제대로 연산하는지 테스트")
    @CsvFileSource(resources = "/Operator/operate.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testOperate(String operator, String arg1, String arg2, String result) {
        Assertions.assertThat(Operator.findOperatorBySymbol(operator).operate(Double.parseDouble(arg1), Double.parseDouble(arg2)))
                .isEqualTo(Double.parseDouble(result));
    }

    @ParameterizedTest
    @DisplayName("존재하지 않는 연산자일때 예외가 발생하는지 테스트")
    @CsvFileSource(resources = "/Operator/invalidSymbols.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testInvalidSymbol(String operator, String arg1, String arg2) {
        Assertions.assertThatThrownBy(() -> {
            Operator op = Operator.findOperatorBySymbol(operator);
            op.operate(Double.parseDouble(arg1), Double.parseDouble(arg2));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 연산자입니다.");
    }

    @ParameterizedTest
    @DisplayName("0으로 나누었을 때 예외가 발생하는지 테스트")
    @CsvFileSource(resources = "/Operator/operatorZeroException.csv", numLinesToSkip = NUM_LINES_TO_SKIP)
    void testZeroDivider(String operator, String arg1, String arg2) {
        Assertions.assertThatThrownBy(() -> {
            Operator op = Operator.findOperatorBySymbol(operator);
            op.operate(Double.parseDouble(arg1), Double.parseDouble(arg2));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
