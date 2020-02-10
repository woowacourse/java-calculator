public class StringValue {
    private static String[] values;
    InputValidation inputValidation = new InputValidation();

    public StringValue() {
        InputValues inputValues = new InputValues();

        values = inputValues.inputValue();
        validateEndWithOperator();
        validateOperator();
        validateDouble();
    }

    public StringValue(String value){
        InputValues inputValues = new InputValues();

        values = inputValues.inputValue(value);
    }

    public void validateDouble(){
        inputValidation.validateDouble(values);
    }

    public void validateOperator(){
        inputValidation.validateOperator(values);
    }

    public void validateEndWithOperator(){
        inputValidation.validateEndWithOperator(values);
    }

    public static String getValueByIndex(int index) {
        return values[index];
    }

    public static int getValuesLength() {
        return values.length;
    }
}
