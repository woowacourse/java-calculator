package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static calculator.util.ExceptionHandler.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionHandlerTest {

    @Test
    @DisplayName("입력값을 체크해주는 테스트")
    public void checkInputHandlerTest() {
        String str = "321 + 3 + f";
        assertThatThrownBy(() -> {
            checkInputHandler(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열을 split하고 전체적으로 체크해주는 테스트")
    void checkStringTest() {
        String[] inputStrings = "333 + 2434343".split(" ");
        assertThat(checkString(inputStrings)).isTrue();
    }

    @Test
    @DisplayName("숫자인지 체크해주는 테스트")
    void checkNumberTest() {
        String str = "g";
        assertThat(checkNumber(str)).isFalse();
    }

    @Test
    @DisplayName("사칙연산인지 체크해주는 테스트")
    void checkSignTest() {
        String str = "@";
        assertThat(checkSign(str)).isFalse();
    }

    @Test
    @DisplayName("0으로 나누었을 때의 예외처리를 해주는 테스트")
    void checkUndefinedValueTest() {
        String str = "0 / 0";
        assertThat(checkUndefinedValue(str)).isFalse();
    }
}