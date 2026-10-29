import java.util.Scanner;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        menu:
        while(true){
            System.out.println("=== EXPENSE TRACKER ===\n" +
                    "1. Add Expense\n" +
                    "2. View All Expenses\n" +
                    "3. Exit\n" +
                    "Choose an option:");
            String choice = sc.nextLine();
            switch (choice){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break menu;
                default:
                    System.out.println("Enter a valid number from 1-3");
                    break;
            }
        }
        sc.close();
    }
}