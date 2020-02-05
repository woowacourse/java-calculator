package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
        Sets sets = new Sets(numbers);
    }

    @Test
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @Test
    void setContains() {
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(2));
        assertTrue(numbers.contains(3));
    }

    @DisplayName("메소드내 입력 값이 많아짐을 줄이기 위한 ParameterizedTest")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void parameterContain(int input) {
        assertTrue(Sets.isContain(input));
    }
}
