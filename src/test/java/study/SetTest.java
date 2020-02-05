package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    void methodStudy_SizeOfSet_IsThree() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void methodStudy_Contains_ValuesOfSet() {
        assertThat(numbers.contains((1))).isTrue();
        assertThat(numbers.contains((2))).isTrue();
        assertThat(numbers.contains((3))).isTrue();
    }
}
