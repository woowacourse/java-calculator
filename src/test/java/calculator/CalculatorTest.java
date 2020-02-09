package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Calculator;
import org.junit.jupiter.api.Test;

import domain.Formula;
import domain.Formulas;

public class CalculatorTest {

    @Test
    void calculateTest() {
        Formulas formulas = new Formulas(new Formula("1 + 2"));
        int result = Calculator.calculateByFormulas(formulas);
        assertThat(result).isEqualTo(3);

        formulas = new Formulas(new Formula("2 + 3 * 4 / 2"));
        result = Calculator.calculateByFormulas(formulas);
        assertThat(result).isEqualTo(10);
    }
}
