package domain;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number add(Number second) {
        return new Number(number + second.number);
    }

    public Number substract(Number second) {
        return new Number(number - second.number);
    }

    public Number multiply(Number second) {
        return new Number(number * second.number);
    }

    public Number divide(Number second) {
        return new Number(number / second.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
