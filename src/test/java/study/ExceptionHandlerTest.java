package study;

import exceptionhandler.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionHandlerTest {
    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static final String OPERATION_PATTERN = "^[+\\-\\*/]$";

    @Test
    @DisplayName("Test isNumber method")
    public void isNumberTest() {
        List<String> nums = Arrays.asList("1", "2", "3");
        assertThat(ExceptionHandler.isNumber(nums)).isTrue();
        nums = Arrays.asList("102", "1356", "9813");
        assertThat(ExceptionHandler.isNumber(nums)).isTrue();
        nums = Arrays.asList("abc", "12", "34");
        assertThat(ExceptionHandler.isNumber(nums)).isFalse();
        nums = Arrays.asList("1a", "2a4", "3s");
        assertThat(ExceptionHandler.isNumber(nums)).isFalse();
    }

    @Test
    @DisplayName("Test isValidOperator method")
    public void isValidOperaterTest() {
        List<String> opers = Arrays.asList("+", "-", "*", "/");
        assertThat(ExceptionHandler.isValidOperator(opers)).isTrue();
        opers = Arrays.asList("a", "b", "c", "d");
        assertThat(ExceptionHandler.isValidOperator(opers)).isFalse();
        opers = Arrays.asList("1", "2", "3", "4");
        assertThat(ExceptionHandler.isValidOperator(opers)).isFalse();
        opers = Arrays.asList("++", "--", "**", "//");
        assertThat(ExceptionHandler.isValidOperator(opers)).isFalse();
        opers = Arrays.asList("+1", "2-", "*3", "/4/");
        assertThat(ExceptionHandler.isValidOperator(opers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "9843"})
    @DisplayName("Test isMatch method")
    public void isMatchTest(String target) {
        assertThat(ExceptionHandler.isMatch(NUMBER_PATTERN, target)).isTrue();
    }
}
