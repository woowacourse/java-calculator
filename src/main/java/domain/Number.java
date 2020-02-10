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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Number num = (Number)o;
        return number == num.number;
    }
}
