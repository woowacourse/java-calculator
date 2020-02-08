package domain;

public class SubstractOperation implements Operation {
    @Override
    public int operate(int number1, int number2) {
        return number1 - number2;
    }
}
