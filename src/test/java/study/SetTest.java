package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SetTest {
    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메소드 연습")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("중복 값 발생 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
        Iterator<Integer> it = numbers.iterator();

    }

    @DisplayName("입력에 따른 결과값이 다른 경우 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:1", "3:1"}, delimiter = ':')
    void containsTo(int actual, int expected) {
        assertThat(actual).isGreaterThan(expected);
    }
}
