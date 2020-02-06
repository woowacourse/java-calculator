package calculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class RunnerTest {
    Runner runner = new Runner();

    @Test
    public void run() {
        String correctInput = "2 * 3 - 1";
        String wrongInput = "2 * 3 -1";

        setInputStream(correctInput);
        runner.run();

        setInputStream(wrongInput);
        runner.run();
    }

    private void setInputStream(String inputStreamAgent) {
        InputStream inputStream = new ByteArrayInputStream(inputStreamAgent.getBytes());
        System.setIn(inputStream);
    }
}
