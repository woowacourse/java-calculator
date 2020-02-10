package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("contains() : return true if Operator contains ValueSource")
    void operatorContains(String operator) {
        assertThat(Arrays.asList(Operator.values()).toString().contains(operator)).isTrue();
    }

    @Test
    @DisplayName("operatorPlus() : return true if Operator.PLUS is equal to +")
    void operatorPlus() {
        String operator = "+";
        Operator o = Operator.PLUS;
        assertThat(o.toString()).isEqualTo(operator);
    }

    @Test
    @DisplayName("operatorMinus() : return true if Operator.MINUS is equal to -")
    void operatorMinus() {
        String operator = "-";
        Operator o = Operator.MINUS;
        assertThat(o.toString()).isEqualTo(operator);
    }

    @Test
    @DisplayName("operatorMultiplification() : return true if Operator.MULTIPLIFICATION is equal to *")
    void operatorMultiplification() {
        String operator = "*";
        Operator o = Operator.MULTIPLIFICATION;
        assertThat(o.toString()).isEqualTo(operator);
    }

    @Test
    @DisplayName("operatorPlus() : return true if Operator.PLUS is equal to +")
    void operatorDivision() {
        String operator = "/";
        Operator o = Operator.DIVISION;
        assertThat(o.toString()).isEqualTo(operator);
    }
}