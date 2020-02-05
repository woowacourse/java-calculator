package calculator.spliter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    @DisplayName("빈칸기준으로 입력식 나누기 테스트")
    @Test
    void stringSplitter() {
        //given
        String input = "2 + 3 * 4";
        //when
        List<String> result = StringSplitter.stringSplitter(input);
        //then
        assertThat(result).containsExactly("2", "+", "3", "*", "4");
    }
}