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
    private ArrayList<Integer> numbers;
    private ArrayList<String> operators;
    private List<Integer> numbersTest;

    @BeforeEach
    void setUp() {  //테스트 전 변수 초기화
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(2);
        operators = new ArrayList<>();
        operators.add("+");
        operators.add("*");
        operators.add("/");
        numbersTest = new ArrayList<>();
        for (int i=0; i < 10; i++) {
            numbersTest.add(i);
        }
    }

    @Test
    @DisplayName("Calculator Calculate Test")
    void isResultCorrect() {    //calculate 함수의 결과 테스트
        int answer = (((1+3)*4)/2);
        int result = Calculator.calculate(numbers.remove(0), numbers, operators);
        assertThat(answer).isEqualTo(result);
        System.out.println("Answer " + answer + " is Correct");
    }


}
