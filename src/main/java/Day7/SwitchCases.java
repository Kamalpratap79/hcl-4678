package Day7;

import java.util.Scanner;

public class SwitchCases {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cases:");
        String day = sc.next();

        String a = switch (day){
            case "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"->"Weekdays";
            default -> "Weekends";
        };
        System.out.println(a);

    }
}
