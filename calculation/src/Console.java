import java.util.Scanner;

public class Console {

    public static String read(){
        Scanner consoleIn = new Scanner(System.in);
        System.out.println("введите выражение:");
        return consoleIn.nextLine();
    }

    public static void print(String massage){
        System.out.println(massage);
    }
}
