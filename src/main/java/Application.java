import domain.Calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        do {
            try{
            System.out.println("정답은 " + new Calculator().run(inputHandler.getInput()) + " 입니다.");
            }catch (ArithmeticException e){
                System.out.println(e.getMessage());
                continue;
            }
        } while (inputHandler.isStartingAgain());
    }
}
