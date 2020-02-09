package domain;

public class CastNumber {
    private final int value;

    public CastNumber(String value) {
        if (!value.matches("^[0-9\\+\\-]?[0-9]+$")) {
            throw new IllegalArgumentException("해당 값은 숫자가 아닙니다. (입력한 숫자 : " + value + ")");
        }
        if ((Integer.MIN_VALUE + "").length() < value.replace("+", "").replace("-", "").replaceAll("^0*", "").length()
                || Long.parseLong(value) > Integer.MAX_VALUE || Long.parseLong(value) < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("해당 값은 계산할 수 있는 범위(Int)를 넘어섰습니다. (입력한 숫자 : " + value + ")");
        }
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }
}
