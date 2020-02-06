package setStudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("numbers의 크기를 확인하는 학습 테스트")
    void setSize() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("numbers에 포함이 되어있을경우 True를 반환하는것을 확인하는 학습테스트 ")
    @ValueSource(ints = {1,2,3})
    void isContains_ShouldReturnTrueForSetElement(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("numbers에 포함이 안되있는경우 False를 반환하는것을 확인하는 학습테스트 ")
    @ValueSource(ints = {4,5,6,7})
    void isContains_ShouldReturnFalseForSetElement(int input) {
        assertThat(numbers.contains(input)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("각 Set element의 input의 contain 여부를 확인하는 학습 테스트")
    @CsvSource(value = {"1, True", "4, False", "5, False"})
    void isContains_EachCheckEachElement(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
