package calculator.spliter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RawEquationSplitterTest {

    @DisplayName("빈칸기준으로 입력식 나누기 테스트")
    @Test
    void stringSplitter() {
        //given
        String input = "2 + 3 * 4";
        //when
        List<String> result = RawEquationSplitter.split(input);
        //then
        assertThat(result).containsExactly("2", "+", "3", "*", "4");
    }

    @DisplayName("입력받은 분리된 식의 구성요소들의 위치가 올바른지 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"2 3 * 4,숫자", "2 % 3 * +,연산자"})
    void split(String equation, String exceptionMessage) {
        assertThatThrownBy(() -> RawEquationSplitter.split(equation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("식이 올바르지 않습니다. %s의 위치를 확인하세요.", exceptionMessage);
    }

}