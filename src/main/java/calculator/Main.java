package calculator;

public class Main {
    public static void main(String[] args) {
        try {
            String[] inputs = StringHandler.getInputAndSplit();
            Source source = new Source(inputs);
        } catch (Exception e) {

        }
    }
}

