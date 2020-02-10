package calculator;

import domain.Calculator;
import domain.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @DisplayName("계산 테스트")
    @ParameterizedTest
    @MethodSource("createOprandAndOperator")
    public void calculate(List<Double> operands, List<Operator> operators, double result) {
        double testValue = new Calculator().calculate(operands, operators);
        Assertions.assertThat(result).isEqualTo(testValue);
    }

    private static Stream<Arguments> createOprandAndOperator() {
        return Stream.of(
                Arguments.of(List.of(3.0, 5.0, 7.0), List.of(Operator.PLUS, Operator.MINUS), 1),
                Arguments.of(List.of(1.0, 5.0, 7.0), List.of(Operator.PLUS, Operator.PLUS), 13),
                Arguments.of(List.of(10.0, 2.0, 4.0), List.of(Operator.MULTIPLY, Operator.DIVISION), 5));
    }
}
