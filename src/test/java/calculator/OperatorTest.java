package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {
    @Test
    void toString_ForLearningTest() {
        for (Operator operator : Operator.values()) {
            System.out.println(operator);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "+,ADDITION",
            "-,SUBTRACTION",
            "*,MULTIPLICATION",
            "/,DIVISION"
    })
    void getOperator_ShouldReturnTrueForValidSymbol(String symbol, String expect) {
        Assertions.assertThat(Operator.getOperator(symbol).toString())
                .isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "++", "a"})
    void getOperator_ShouldGenerateIllegalArgumentExceptionForInvalidSymbol(String symbol) {
        Assertions.assertThatThrownBy(() -> Operator.getOperator(symbol))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,6", "3,-4,-1"})
    void calculate_ForADDITION(double a, double b, double result) {
        Assertions.assertThat(Operator.ADDITION.calculate(a, b))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,0", "3,-4,7"})
    void calculate_ForSUBTRACTION(double a, double b, double result) {
        Assertions.assertThat(Operator.SUBTRACTION.calculate(a, b))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,9", "3,-4,-12", "3,0,0"})
    void calculate_ForMULTIPLICATION(double a, double b, double result) {
        Assertions.assertThat(Operator.MULTIPLICATION.calculate(a, b))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,1", "12,-4,-3"})
    void calculate_ForDIVISION(double a, double b, double result) {
        Assertions.assertThat(Operator.DIVISION.calculate(a, b))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 0})
    void calculate_ShouldGenerateIllegalArgumentExceptionForDIVISION(int dividend) {
        Assertions.assertThatThrownBy(() -> Operator.DIVISION.calculate(dividend, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
