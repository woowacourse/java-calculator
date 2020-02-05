package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("size test")
    void size() {
        Assertions.assertEquals(numbers.size(), 3);
    }

    @ParameterizedTest
    @DisplayName("contains test")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @DisplayName("contains test 2")
    @CsvSource(value = {"1:true", "2: true", "3:true", "4:false"}, delimiter = ':')
    void contains_CanCheckTrueAndFalse(int index, boolean expected) {
        assertThat(numbers.contains(index)).isEqualTo(expected);
    }
}
