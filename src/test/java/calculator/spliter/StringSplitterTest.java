package calculator.spliter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSplitterTest {

    @DisplayName("빈칸기준으로 입력식 나누기 테스트")
    @Test
    void stringSplitter() {
        //given
        String input = "2 + 3 * 4";
        //when
        List<String> result = StringSplitter.split(input);
        //then
        assertThat(result).containsExactly("2", "+", "3", "*", "4");
    }

    @DisplayName("숫자와 연산자가 벌갈아 잘 나오는지 체크 테스트")
    @Test
    void split() {
        //given
        String equation = "2 3 * 4";
        //when
        assertThatThrownBy(() -> {
            StringSplitter.split(equation);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치가 잘못되었습니다.");
        //then
    }
}