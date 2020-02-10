package calculator;

import domain.Numbers;
import domain.OperatorGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("덧셈 테스트")
    @Test
    void calculatePlus() {
        List<String> numberGroup = new ArrayList<String>();
        List<OperatorGroup> operators = new ArrayList<>();
        numberGroup.add("1");
        numberGroup.add("2");
        operators.add(OperatorGroup.PLUS);
        Numbers numbers = new Numbers(numberGroup);
        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void calculateMinus() {
        List<String> numberGroup = new ArrayList<String>();
        List<OperatorGroup> operators = new ArrayList<>();
        numberGroup.add("5");
        numberGroup.add("2");
        operators.add(OperatorGroup.MINUS);
        Numbers numbers = new Numbers(numberGroup);
        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void calculateMultiply() {
        List<String> numberGroup = new ArrayList<String>();
        List<OperatorGroup> operators = new ArrayList<>();
        numberGroup.add("1");
        numberGroup.add("2");
        operators.add(OperatorGroup.MULTIPLY);
        Numbers numbers = new Numbers(numberGroup);
        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void calculateDivide() {
        List<String> numberGroup = new ArrayList<String>();
        List<OperatorGroup> operators = new ArrayList<>();
        numberGroup.add("4");
        numberGroup.add("2");
        operators.add(OperatorGroup.DIVIDE);
        Numbers numbers = new Numbers(numberGroup);
        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(2);
    }
}