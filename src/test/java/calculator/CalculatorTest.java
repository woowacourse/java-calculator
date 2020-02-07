package calculator;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class CalculatorTest {
    private Set operators;
    private Calculator cal;

    @BeforeEach
    void setUp() {
        operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        cal = new Calculator();
    }

    @Test
    void makeQueueTest(){
        String input = "1 + 2 + 3 / 4";
        Queue equation = cal.makeQueue(input);
        while (!equation.isEmpty()) {
            System.out.println(equation.poll());
           //Assertions.assertThat(equation.poll()).isNotEqualTo("");
        }

    }
    @Test
    void calculateTest(){
        Assertions.assertThat(cal.calculate(1, "+", 2)).isEqualTo(1+2);
        Assertions.assertThat(cal.calculate(1, "-", 2)).isEqualTo(1-2);
        Assertions.assertThat(cal.calculate(1, "*", 2)).isEqualTo(1*2);
        Assertions.assertThat(cal.calculate(1, "/", 2)).isEqualTo(1/2);
    }
}
