package calculator.view;

public class OutputView {
    public static void printResult(double result){
        String printFormat = "결과는 %f 입니다.";
        if(result == Math.floor(result)){
            printFormat = "결과는 %.0f 입니다.";
        }
        System.out.printf(printFormat, result);
    }
}
