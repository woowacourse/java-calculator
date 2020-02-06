package setStudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("numbers의 크기를 확인하는 학습 테스트")
    void setSize() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("numbers에 포함이 되어있을경우 True를 반환하는것을 확인하는 학습테스트 ")
    void isContains_ShouldReturnTrueForSetElement(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    @DisplayName("numbers에 포함이 안되있는경우 False를 반환하는것을 확인하는 학습테스트 ")
    void isContains_ShouldReturnFalseForSetElement(int input) {
        assertThat(numbers.contains(input)).isFalse();
    }
}
