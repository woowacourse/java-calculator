package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
    private Set<Integer> numbers;
    private List<Integer> initNumbers = Arrays.asList(1,1,2,3);

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.addAll(initNumbers);
    }

    @Test
    @DisplayName("#size() : return size of distict initNumbers")
    void size() {
        int expectedSize = initNumbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();

        assertThat(numbers.size()).isEqualTo(expectedSize);

    }

    @ParameterizedTest
    //todo: refac hardcoding
    @ValueSource(ints = {1,2,3})
    @DisplayName("#contains() : return true if set contains valueSource")
    void contains(Integer input) {
        assertThat(numbers.contains(input)).isTrue();

    }
}
