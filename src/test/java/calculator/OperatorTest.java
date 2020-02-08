package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperatorTest {
    private static List<String> operators = Arrays.asList("+", "-", "*", "/");
    private static List<String> notOperators = Arrays.asList("", "a", "++");
    private static List<Operator> expects = Arrays.asList(Operator.values());

    @Test
    void getOperator() {
        for (int i = 0; i < operators.size(); i++) {
            for (int j = 0; j < expects.size(); j++) {
                if (i == j) {
                    Assertions.assertThat(Operator.getOperator(operators.get(i))).isEqualTo(expects.get(j));
                }
                if (i != j) {
                    Assertions.assertThat(Operator.getOperator(operators.get(i))).isNotEqualTo(expects.get(j));
                }

            }
        }

        for (String notOperator: notOperators) {
            Assertions.assertThatThrownBy(() -> {
                Operator.getOperator(notOperator);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
