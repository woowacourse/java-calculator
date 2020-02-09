package calculator;

import org.junit.jupiter.api.Test;

public class ExpressionTest {
    private final String CORRECT_CASE = "2 + 3 * 2";
    private final String WRONG_CASE = "2 + 3 *2";

    @Test
    public void constructor() {
        System.out.println("correct testcase test start");
        Expression correctTest = new Expression(CORRECT_CASE);
        System.out.println("correct testcase test end");

        System.out.println("wrong testcase start");
        Expression wrongTest = new Expression(WRONG_CASE);
        System.out.println("correct testcase test end");
    }
}
