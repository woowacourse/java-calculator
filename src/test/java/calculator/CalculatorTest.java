package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void run() {
    }

    @DisplayName("계산 테스트")
    @Test
    void calculate() {
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        operators.add("+");
        operators.add("-");
        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("연산자 별 연산 확인")
    @Test
    void doOperation() {
        double plusResult = Calculator.doOperation("+", 3, 5);
        assertThat(plusResult).isEqualTo(8);
        double minusResult = Calculator.doOperation("-", 3, 5);
        assertThat(minusResult).isEqualTo(-2);
        double multipleResult = Calculator.doOperation("*", 1, 2);
        assertThat(multipleResult).isEqualTo(2);
        double divideResult = Calculator.doOperation("/", 4, 2);
        assertThat(divideResult).isEqualTo(2);
    }
}