package domain;

public class AddOperation implements Operation {
    @Override
    public int operate(int number1, int number2) {
        return number1 + number2;
    }
}
