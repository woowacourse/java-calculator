package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OperatorTest {
    private static List<String> operatorStrings = Arrays.asList("+", "-", "*", "/");
    private static List<String> notOperatorStrings = Arrays.asList("", "a", "++");
    List<Operator> operators = Arrays.asList(Operator.addition, Operator.subtraction, Operator.multiplication, Operator.division);

    @Test
    void getOperator() {
        for (int i = 0; i < operatorStrings.size(); i++) {
            for (int j = 0; j < operators.size(); j++) {
                if (i == j) {
                    Assertions.assertThat(Operator.getOperator(operatorStrings.get(i))).isEqualTo(operators.get(j));
                }
                if (i != j) {
                    Assertions.assertThat(Operator.getOperator(operatorStrings.get(i))).isNotEqualTo(operators.get(j));
                }

            }
        }

        for (String notOperator : notOperatorStrings) {
            Assertions.assertThatThrownBy(() -> {
                Operator.getOperator(notOperator);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void calculate() {
        double a = 3;
        double b = 3;
        double zero = 0;

        Assertions.assertThat(Operator.addition.calculate(a, b)).isEqualTo(a + b);
        Assertions.assertThat(Operator.subtraction.calculate(a, b)).isEqualTo(a - b);
        Assertions.assertThat(Operator.multiplication.calculate(a, b)).isEqualTo(a * b);
        Assertions.assertThat(Operator.division.calculate(a, b)).isEqualTo(a / b);
        Assertions.assertThatThrownBy(() -> {
            Operator.division.calculate(a, zero);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
