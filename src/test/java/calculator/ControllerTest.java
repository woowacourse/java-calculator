package calculator;

import domain.Controller;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerTest {
    Controller controller = new Controller();

    @DisplayName("계산식 분할 테스트")
    @Test
    void splitFormula() {
        String formula = "3 + 2 - 1";
        double[] numbers = {3, 2, 1};
        char[] operators = {'+', '-'};

        controller.splitFormula(formula);

        double[] targetNumbers = controller.getNumbers().stream().mapToDouble(Double::doubleValue).toArray();
        Assertions.assertThat(numbers).isEqualTo(targetNumbers);

        char[] targetOperators = new char[controller.getOperators().size()];
        for (int i = 0; i < controller.getOperators().size(); i++) {
            targetOperators[i] = controller.getOperators().get(i);
        }
        Assertions.assertThat(operators).isEqualTo(targetOperators);
    }

}
