package calculator;

public interface Operator {
    double calculate(double a, double b);
}

class Add implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

class Subtract implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}

class Multiply implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}

class Divide implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a / b;
    }
}