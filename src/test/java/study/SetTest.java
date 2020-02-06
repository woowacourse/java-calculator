package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("size()를 호출하면 set에 담겨 있는 요소의 개수를 반환")
    void testSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains(number)를 호출하면 number가 set에 있으면 True를 반환")
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }
}
