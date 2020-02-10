package study;


import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetCollectionTest {
    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set 크기 확인")
    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set 값 확인")
    @ValueSource(strings = {"1", "2", "3"})
    void containNumbers(String input) {
        assertThat(numbers.contains(Integer.parseInt(input))).isTrue();
//        assertThat(numbers).contains(Integer.parseInt(input));
    }

    @ParameterizedTest
    @DisplayName("Set 값 확인, 예외적 경우 포함")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"},delimiter = ':')
    void containNumbers(String input, String expected) {
        int number = Integer.parseInt(input);
        String actual = String.valueOf(numbers.contains(number));
        assertThat(actual).isEqualTo(expected);
    }

}
