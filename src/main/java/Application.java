public class Application {
    public static void main(String args[]){
        InputHandler inputHandler = new InputHandler();
        OutputView.printAnswer(Calculator.run(inputHandler.getInput()));
    }
}
