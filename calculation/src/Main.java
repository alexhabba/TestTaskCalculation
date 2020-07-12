public class Main {
    public static void main(String[] args) throws Exception {
        Convert convert = new Convert(Console.read());
        Calculation calculation = new Calculation(convert.getValue1(),
                convert.getValue2(), convert.getOperation());
        int rez = calculation.executeCalculation();
        if (!convert.isRome()){
            Console.print(String.valueOf(rez));
        }else{
            Console.print(convert.convertIntToString(rez));
        }
    }
}
