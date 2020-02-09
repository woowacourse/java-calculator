package StringCalculatorTest;

import Controller.Operator;
import Controller.OperatorMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    List<Integer> numbers = new ArrayList<>();
    List<Operator> operators = new ArrayList<>();

    @BeforeEach
    void setUp(){
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        operators.add(OperatorMap.getOperatorByString("+"));
        operators.add(OperatorMap.getOperatorByString("-"));
        operators.add(OperatorMap.getOperatorByString("*"));
    }

    @DisplayName("문자열 식 계산")
    @Test
    void calculate() {
        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++){
            result = operators.get(i).compute(result, numbers.get(i+1));
        }
        assertThat(result).isEqualTo(0);
    }
}
