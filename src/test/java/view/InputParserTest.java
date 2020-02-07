package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.InputParser;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

class InputParserTest {

    @DisplayName("문자열 분리 테스트")
    @Test
    void split() {
        String[] result = InputParser.split("2 + 3 * 5");
        String[] expected = {"2", "+", "3", "*", "5"};
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 추출 테스트")
    @Test
    void extractNumber() {
        String[] splitted = {"2", "+", "3", "*", "5"};
        ArrayList<String> result = InputParser.extractNumber(splitted);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("2");
        expected.add("3");
        expected.add("5");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void extractOperator() {
        String[] splitted = {"2", "+", "3", "*", "5"};
        ArrayList<String> result = InputParser.extractOperator(splitted);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("+");
        expected.add("*");
        assertThat(result).isEqualTo(expected);
    }
}