import java.util.ArrayList;
import java.util.List;

public class Convert {
    List<Integer> list = new ArrayList<>();
    private boolean isRome = false;
    private String string;
    private int value1;
    private int value2;
    private String operation;

    public Convert(String string) throws Exception {
        this.string = string;
        setOperationAndValues();
        value1 = list.get(0);
        value2 = list.get(1);
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public String getOperation() {
        return operation;
    }

    public boolean isRome() {
        return isRome;
    }

    @Override
    public String toString() {
        return "Convert{" +
                "string='" + string + '\'' +
                ", list=" + list +
                ", value1=" + value1 +
                ", value2=" + value2 +
                ", operation='" + operation + '\'' +
                '}';
    }

    private void setOperationAndValues() throws Exception {
        String[] str = string.split("[+*/\\-]");
        if (str.length == 2){
            String value1 = str[0].trim();
            String value2 = str[1].trim();
            operation = string.replace(value1, "").replace(value2, "").trim();
            checkValues(value1, value2);
        }
    }

    private void checkValues(String str1, String str2) throws Exception {
        boolean decNumber1 = getResult(str1);
        boolean decNumber2 = getResult(str2);

        if (decNumber1 && decNumber2){
            return;
        }

        if (decNumber1 ^ decNumber2){
            throw new NumberFormatException("Вы ввели не подходящие числа");
        }

        convertRomNumber(str1, str2);
    }

    private void convertRomNumber(String str1, String str2) throws Exception {
        list.add(getRomeNumber(str1));
        list.add(getRomeNumber(str2));
        isRome = true;
    }

    //	MML
    private static int getRomeNumber(String str) throws Exception {
        int rez = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            RomeNumber[] values = RomeNumber.values();
            int val = 0;
            int valBack = 0;
            for (int j = 0; j < values.length; j++) {
                if (str.charAt(i) == values[j].toString().charAt(0)){
                    val = values[j].getNumber();
                    break;
                }
            }

            for (int j = 0; j < values.length; j++) {
                if (i != 0 && str.charAt(i - 1) == values[j].toString().charAt(0)){
                    valBack = values[j].getNumber();
                    break;
                }
            }

            if (val == 0){
                throw new Exception("Вы ввели не подходящие числа");
            }
            if (val > valBack){
                rez += val - valBack;
                i--;
            } else {
                rez += val;
            }
        }
        return rez;
    }


    private boolean getResult(String str){
        try {
            list.add(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public String convertIntToString(int value){
        String result = "";
        while (value > 0){
            if ((value / 1000) >= 1){
                result = result + "M";
                value = value - 1000;
            }
            else if  ((value / 500) >= 1){
                result = result + "D";
                value = value - 500;
            }
            else if ((value / 100) >= 1){
                result = result + "C";
                value = value - 100;
            }
            else if ((value / 50) >= 1){
                result = result + "L";
                value = value - 50;
            }
            else if ((value / 10) >= 1){
                result = result + "X";
                value = value - 10;
            }
            else if ((value / 1) >= 1){
                switch ((value / 1)) {
                    case 9:
                        result = result + "IX";
                        value = value - 9;
                        break;
                    case 8:
                        result = result + "VIII";
                        value = value - 8;
                        break;
                    case 7:
                        result = result + "VII";
                        value = value - 7;
                        break;
                    case 6:
                        result = result + "VI";
                        value = value - 6;
                        break;
                    case 5:
                        result = result + "V";
                        value = value - 5;
                        break;
                    case 4:
                        result = result + "IV";
                        value = value - 4;
                        break;
                    case 3:
                        result = result + "III";
                        value = value - 3;
                        break;
                    case 2:
                        result = result + "II";
                        value = value - 2;
                        break;
                    case 1:
                        result = result + "I";
                        value = value - 1;
                        break;
                }
            }
        }
        return result;
    }
}