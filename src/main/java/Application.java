import expression.Expression;
import input.CalculatorInputScanner;

public class Application {

    public static void main(String[] args) {
        String userExpression = CalculatorInputScanner.getExpression();

        Expression expression = new Expression(userExpression);
        Double userResult = expression.getResult();

        System.out.println("결과 : " + userResult);
    }
}
