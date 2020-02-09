package calculator;

import domain.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    private static int TEST_COUNTS = 10;

    @DisplayName("PLUS TEST")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    void plus(Double operand1, Double operand2) {
        double expected = operand1 + operand2;
        assertThat(Operator.PLUS.calculate(operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("MINUS TEST")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    void minus(Double operand1, Double operand2) {
        double expected = operand1 - operand2;
        assertThat(Operator.MINUS.calculate(operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("MULTIPLY TEST")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    void multiply(Double operand1, Double operand2) {
        double expected = operand1 * operand2;
        assertThat(Operator.MULTIPLY.calculate(operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("DIVIDE TEST")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    void divide(Double operand1, Double operand2) {
        double expected = operand1 / operand2;
        assertThat(Operator.DIVIDE.calculate(operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("DIVIDE TEST / 0")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    void divideZero(Double operand1) {
        assertThatThrownBy(() -> Operator.DIVIDE.calculate(operand1, 0.0)).isInstanceOf(IllegalArgumentException.class)
                                                                          .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @BeforeEach
    void createCSV() throws Exception {
        Random random = new Random();
        BufferedWriter fw = new BufferedWriter(new FileWriter("out/test/classes/testData.csv"));
        for (int i = 0; i < TEST_COUNTS; i++) {
            fw.write(random.nextDouble() + ", " + random.nextDouble());
            fw.newLine();
        }
        fw.flush();
        fw.close();
    }
}
