import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();
        int nextId = 1;

        menu:
            while(true){
                System.out.println("""
                        === EXPENSE TRACKER ===
                        1. Add Expense
                        2. View All Expenses
                        3. Exit
                        Choose an option:""");
                String choice = sc.nextLine();
                switch (choice){
                    case "1":
                        System.out.print("Enter amount:");
                        BigDecimal amount = new BigDecimal(sc.nextLine());
                        System.out.print("Enter category:");
                        String category = sc.nextLine();
                        System.out.print("Enter date (YYYY-MM-DD):");
                        LocalDate date = LocalDate.parse(sc.nextLine());

                        Expense expense = new Expense(nextId++,amount,category,date);
                        expenses.add(expense);
                        System.out.print("Expense added successfully!\n");
                        break;

                    case "2":
                        if(expenses.isEmpty()){
                            System.out.print("Expenses yet to be added...\n");
                            break;
                        }
                        for(Expense n:expenses){
                            System.out.println(n);
                        }
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