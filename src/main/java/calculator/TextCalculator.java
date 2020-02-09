package calculator;

public class TextCalculator {
    private static final int STANDARD_NUMBER = 0;
    public static final String BLANK = " ";

    public double run(String input) {
        String[] inputArray = split(input);

        double result = Double.parseDouble(inputArray[STANDARD_NUMBER]);
        for (int i = 1; i < inputArray.length; i += 2) {
            Operator operator = Operator.of(inputArray[i]);
            double right = Double.parseDouble(inputArray[i+1]);
            result = operator.calculate(result, right);
        }
        return result;
    }
    
    public String[] split(String target) {
        return target.split(BLANK);
    }
}
