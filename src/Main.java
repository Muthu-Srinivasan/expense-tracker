import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> store = new ArrayList<>();
        int nextId = 1;

        menu:
            while(true){
                System.out.println("""
                        === EXPENSE TRACKER ===
                        1. Add Expense
                        2. View All Expenses
                        3. Delete Expense
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
                        store.add(expense);
                        System.out.print("Expense added successfully!\n");
                        break;

                    case "2":
                        if(store.isEmpty()){
                            System.out.print("Expenses yet to be added...\n");
                            break;
                        }
                        for(Expense n:store){
                            System.out.println(n);
                        }
                        break;
                    case "3":
                        System.out.print("Enter the expense id:");
                        int userInput = Integer.parseInt(sc.nextLine());
                        Expense temp = null;
                        for(Expense m:store){
                            if(m.id()==userInput){
                                temp = m;
                                break;
                            }
                        }
                        if (temp!= null) {
                            store.remove(temp);
                            System.out.println("Expense deleted successfully.");
                        } else {
                            System.out.println("Expense ID not found.");
                        }
                    case "4":
                        break menu;
                    default:
                        System.out.println("Enter a valid choice (1-4)");
                        break;
                }
            }
        sc.close();
    }
}