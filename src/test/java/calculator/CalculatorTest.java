package calculator;

import domain.Numbers;
import domain.OperatorGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CalculatorTest {

    @Test
    void run() {
    }

    @DisplayName("Plus 테스트")
    @Test
    void plusCalculate() {
        List<String> numberStrings = new ArrayList<>();
        numberStrings.add("4");
        numberStrings.add("2");
        Numbers numbers = new Numbers(numberStrings);

        List<OperatorGroup> operators = new ArrayList<>();
        operators.add(OperatorGroup.PLUS);

        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("Minus 테스트")
    @Test
    void minusCalculate() {
        List<String> numberStrings = new ArrayList<>();
        numberStrings.add("4");
        numberStrings.add("2");
        Numbers numbers = new Numbers(numberStrings);

        List<OperatorGroup> operators = new ArrayList<>();
        operators.add(OperatorGroup.MINUS);

        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("Multiple 테스트")
    @Test
    void multipleCalculate() {
        List<String> numberStrings = new ArrayList<>();
        numberStrings.add("4");
        numberStrings.add("2");
        Numbers numbers = new Numbers(numberStrings);

        List<OperatorGroup> operators = new ArrayList<>();
        operators.add(OperatorGroup.MULTIPLY);

        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("Divide 테스트")
    @Test
    void divideCalculate() {
        List<String> numberStrings = new ArrayList<>();
        numberStrings.add("4");
        numberStrings.add("2");
        Numbers numbers = new Numbers(numberStrings);

        List<OperatorGroup> operators = new ArrayList<>();
        operators.add(OperatorGroup.DIVIDE);

        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("연속된 사칙 연산 테스트")
    @Test
    void connectedArithmeticCalculate() {
        List<String> numberStrings = new ArrayList<>();
        numberStrings.add("4");
        numberStrings.add("2");
        numberStrings.add("4");
        numberStrings.add("2");
        Numbers numbers = new Numbers(numberStrings);

        List<OperatorGroup> operators = new ArrayList<>();
        operators.add(OperatorGroup.DIVIDE);
        operators.add(OperatorGroup.PLUS);
        operators.add(OperatorGroup.MULTIPLY);

        double result = Calculator.calculate(numbers, operators);
        assertThat(result).isEqualTo(12);
    }

}