package view;

public enum YesNo {
    y,
    n;

    public boolean toBoolean() {
        if (this == y) {
            return true;
        }
        return false;
    }
}
