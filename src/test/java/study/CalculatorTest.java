package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import calculator.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

// Test
// 입력되는 공식은
// 1 + 3 * 4 / 2
// 로 가정하여 진행

public class CalculatorTest {

    @Test
    @DisplayName("Calculator Calculate Test")
    void isResultCorrect() {    //calculate 함수의 결과 테스트
        Calculator calculator = new Calculator();
        int answer = (((1+3)*4)/2);
        List<List> expressions = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        numbers.add("1");
        numbers.add("3");
        numbers.add("4");
        numbers.add("2");

        operators.add("+");
        operators.add("*");
        operators.add("/");

        expressions.add(numbers);
        expressions.add(operators);

        int result = calculator.calculate(expressions);
        assertThat(answer).isEqualTo(result);
        System.out.println("Answer " + answer + " is Correct");
    }
}
