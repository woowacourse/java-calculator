package calculator.spliter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("입려받은 분리된 식의 숫자 위치가 올바른지 확인하기")
    @Test
    void split() {
        String equation = "2 3 * 4";

        assertThatThrownBy(() -> RawEquationSplitter.split(equation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치가 잘못되었습니다.");
    }

    @DisplayName("입려받은 분리된 식의 연산자 위치가 올바른지 확인하기")
    @Test
    void split2() {
        String equation = "2 % 3 * +";

        assertThatThrownBy(() -> RawEquationSplitter.split(equation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자의 위치가 잘못되었습니다.");
    }
}