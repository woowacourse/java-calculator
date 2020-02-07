package calculator;

import domain.Calculator;
import domain.Formulas;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void calculateTest() {
        Calculator calculator = new Calculator(new Formulas("1 + 2"));
        int result = calculator.startCalculate();
        assertThat(result).isEqualTo(3);
        Calculator calculator2 = new Calculator(new Formulas("2 + 3 * 4 / 2"));
        result = calculator2.startCalculate();
        assertThat(result).isEqualTo(10);
    }


}
