import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class calculateTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    @DisplayName("나누기 연산자 바로뒤에 0이 있으면 True를 반환하고 아니면 False를 반환한다.")
    void divideByZeroTest() {
        String[] wrongEquations = {"1","/","0"};
        String[] rightEquations = {"1","/","1"};
        assertThat(calculator.isDividedByZero(wrongEquations,1)).isEqualTo(true);
        assertThat(calculator.isDividedByZero(rightEquations,1)).isEqualTo(false);
    }

}
