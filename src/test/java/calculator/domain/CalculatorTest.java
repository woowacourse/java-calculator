package calculator.domain;


import calculator.domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    void makeQueueTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String input = "1 + 2 + 3 / 4";
        Method makeQueue = cal.getClass().getDeclaredMethod("makeQueue", String.class);
        makeQueue.setAccessible(true);
        Queue equation = (Queue<String>) makeQueue.invoke(cal, input);
        while (!equation.isEmpty()) {
            System.out.println(equation.poll());
           //Assertions.assertThat(equation.poll()).isNotEqualTo("");
        }

    }
    @Test
    void calculateTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method calculate = cal.getClass().getDeclaredMethod("calculate", int.class, String.class, int.class);
        calculate.setAccessible(true);
        Assertions.assertThat(calculate.invoke(cal, 1, "+", 2)).isEqualTo(1+2);
        Assertions.assertThat(calculate.invoke(cal, 1, "-", 2)).isEqualTo(1-2);
        Assertions.assertThat(calculate.invoke(cal, 1, "*", 2)).isEqualTo(1*2);
        Assertions.assertThat(calculate.invoke(cal, 1, "/", 2)).isEqualTo(1/2);
    }
}
