package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionHandlerTest {
    private static final int EVEN = 0;
    private static final int ODD = 1;
    private static final int INDEX_INIT = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static String inputHandler() {
        try {
            return checkInputHandler(scanner.nextLine());
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("입력값을 확인해주세요.");
            scanner = new Scanner(System.in);
            return inputHandler();
        }
    }

    private static String checkInputHandler(String input) {
        if (checkString(input.split(" ")) == true && isUndefinedValue(input) == true) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    @Test
    @DisplayName("핸들러 동작 확인")
    public void checkInputHandlerTest() {
        String str = "321 + 3 + f";
        assertThatThrownBy(() -> {
            checkInputHandler(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static boolean checkString(String[] inputStrings) {
        if (inputStrings.length % 2 == EVEN) {
            return false;
        }
/*        for (int i = INDEX_INIT; i < inputStrings.length; i++) {
            if (checkIndividual(i, inputStrings[i]) == false) {
                return false;
            }
        }*/
        // depth 1으로 대신하는 코드
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(inputStrings)
                .allMatch(x -> checkIndividual(index.getAndIncrement(), x));
    }

    @Test
    @DisplayName("문자열 체크 확인")
    void checkStringTest() {
        String[] inputStrings = "333 + 2434343".split(" ");
        assertThat(checkString(inputStrings)).isTrue();
    }

    private static boolean checkIndividual(int i, String inputString) {
        if (i % 2 == EVEN) {
            return checkNumber(inputString);
        }
        if (i % 2 == ODD) {
            return checkSign(inputString);
        }
        return false;
    }

    private static boolean checkNumber(String inputString) {
        return inputString.matches("-?\\d+(\\.\\d+)?");
    }

    @Test
    @DisplayName("숫자 판별 확인")
    void checkNumberTest() {
        String str = "g";
        assertThat(checkNumber(str)).isFalse();
    }

    private static boolean checkSign(String inputString) {
        if (inputString.equals("+")) {
            return true;
        }
        if (inputString.equals("-")) {
            return true;
        }
        if (inputString.equals("*")) {
            return true;
        }
        if (inputString.equals("/")) {
            return true;
        }
        return false;
    }

    @Test
    @DisplayName("부호 판별 확인")
    void checkSignTest() {
        String str = "@";
        assertThat(checkSign(str)).isFalse();
    }

    public static boolean isUndefinedValue(String str) {
        if (str.replace(" ", "").contains("/0")) {
            return false;
        }
        return true;
    }

    @Test
    @DisplayName("0으로 나누기 판별 확인")
    void isUndefinedValueTest() {
        String str = "0 / 0";
        assertThat(isUndefinedValue(str)).isFalse();
    }
}