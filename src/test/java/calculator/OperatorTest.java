package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    public void 옳바른_연산자를_리턴하는지_테스트 () throws IllegalAccessException {
        Operator plus = Operator.of("+");
        Operator minus = Operator.of("-");
        Operator multiply = Operator.of("*");
        Operator divide = Operator.of("/");

        assertThat(plus).isEqualTo(Operator.PLUS);
        assertThat(minus).isEqualTo(Operator.SUBTRACT);
        assertThat(multiply).isEqualTo(Operator.MULTIPLY);
        assertThat(divide).isEqualTo(Operator.DIVIDE);
    }

}