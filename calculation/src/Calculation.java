public class Calculation {
    private int value1;
    private int value2;
    private String operation;

    public Calculation(int value1, int value2, String operation) {
        this.value1 = value1;
        this.value2 = value2;
        this.operation = operation;
    }

    public int executeCalculation() throws Exception {
        switch (operation){
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return value1 / value2;
        }
        throw new Exception("Вы ввели не подходящие числа");
    }
}
