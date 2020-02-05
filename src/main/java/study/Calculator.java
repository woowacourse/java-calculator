package study;

public class Calculator {

    public static int add(int input1, int input2) {
        return input1 + input2;
    }

    public static int subtract(int input1, int input2) {
        return input1 - input2;
    }

    public static int multiply(int input1, int input2) {
        return input1 * input2;
    }

    public static int divide(int input1, int input2) {
        return input1 / input2;
    }

    public static void main(String[] args) {

    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        String[] values = input.split(" ");
//        int result = Integer.parseInt(values[0]);
//        for (int i=1; i<values.length; i=i+2) {
//            if (values[i].equals("+")) result += Integer.parseInt(values[i+1]);
//            else if (values[i].equals("-")) result -= Integer.parseInt(values[i+1]);
//            else if (values[i].equals("*")) result *= Integer.parseInt(values[i+1]);
//            else if (values[i].equals("/")) result /= Integer.parseInt(values[i+1]);
//        }
//        System.out.println(result);
//    }
}
