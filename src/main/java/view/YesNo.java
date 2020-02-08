package view;

public enum YesNo {
    Y,
    N;

    public boolean toBoolean() {
        if (this == Y) {
            return true;
        }
        return false;
    }
}
