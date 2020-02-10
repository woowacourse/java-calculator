import java.util.Scanner;

public class InputValues {
    public String[] inputValue() {
        String value;
        String[] values;

        System.out.print("문자열 수식을 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();

        values = value.split(" ");

        return values;
    }

    //Test를 위한 메소드
    public String[] inputValue(String value){
        return value.split(" ");
    }
}
