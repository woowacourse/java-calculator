package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorsTest {

    @Test
    public void valueOf() {
        String symbol = "PLUS";
        assertThat(Operators.valueOf(symbol)).isEqualTo(Operators.PLUS);
    }

    @Test
    public void hasThis() {
        String symbol = "+";
        assertThat(Operators.PLUS.hasThis(symbol)).isTrue();

        symbol = new String("+");
        assertThat(Operators.PLUS.hasThis(symbol)).isTrue();
    }

    @Test
    public void findOperator() {
        String symbol = "+";
        assertThat(Operators.findOperator(symbol)).isEqualTo(Operators.PLUS);

        String notSupportedSymbol = "%";
        //assertThatThrownBy(() -> Operators.findOperator(notSupportedSymbol))
        //        .isInstanceOf(InputMismatchException.class);
        assertThatExceptionOfType(InputMismatchException.class)
                .isThrownBy(() -> Operators.findOperator(notSupportedSymbol));
    }
}
