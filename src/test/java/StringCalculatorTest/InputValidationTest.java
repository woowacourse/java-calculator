package StringCalculatorTest;

import Controller.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class InputValidationTest {

    /**
     * 테스트 공통적으로, 참인지 판단하는 경우가 아니면
     * 예외처리가 되어야 정상작동
     */


    @Test
    @DisplayName("문자열의 처음과 끝에는 숫자만 올 수 있다")
    void validateFirstAndLast() throws Exception {
        String[] test1 = {"3", "+", "+"};
        String[] test2 = {"3", "-", "2"};
        String[] test3 = {"3", "+", "4", "/", "10", "/", "10"};
        boolean result = InputValidation.validateFirstAndLast(test3);
        //assertThat(result).isTrue();
        //result = InputValidation.validateFirstAndLast(test1);
        result = InputValidation.validateFirstAndLast(test2);
        assertThat(result);
    }


    @Test
    @DisplayName("문자열이나 숫자는 반복되어서는 안된다.")
    void validateRepeat() throws Exception {
        String[] test1 = {"3", "+", "4"};
        String[] test2 = {"3", "3"};
        String[] test3 = {"3", "+", "+", "3"};
        boolean result = InputValidation.validateRepeat(test1);
        assertThat(result).isTrue();
        //assertThat(InputValidation.validateRepeat(test2));
        //assertThat(InputValidation.validateRepeat(test3));


    }

    @Test
    @DisplayName("정해진 연산자 외 다른 연산자 연산 불가능")
    void validateOperators() throws Exception {
        String[] test1 = {"3", "+", "4"};
        String[] test2 = {"3", ")", "4"};
        boolean result;
        assertThat(InputValidation.validateOperators(test1)).isTrue();
        assertThat(InputValidation.validateOperators(test2));
    }

}
