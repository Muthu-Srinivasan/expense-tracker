import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
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
            while(true) {
                System.out.println("""
                        === EXPENSE TRACKER ===
                        1. Add Expense
                        2. View All Expenses
                        3. Delete Expense
                        4. Exit
                        Choose an option:""");
                int choice = 0;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter numbers only (1-4):");
                }
                switch (choice) {

                    //Adding Expense
                    case 1:

                        BigDecimal amount;

                        while (true) {
                            try {
                                System.out.print("Enter amount: ");
                                amount = new BigDecimal(sc.nextLine());

                                if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                                    System.out.println("Amount must be greater than zero.");
                                    continue;
                                }

                                break;

                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid amount.");
                            }
                        }

                        String category;

                        while (true) {
                            System.out.print("Enter category: ");
                            category = sc.nextLine().trim();

                            if (category.isEmpty()) {
                                System.out.println("Category can't be empty!");
                                continue;
                            }

                            break;
                        }

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu")
                                .withResolverStyle(ResolverStyle.STRICT);

                        LocalDate date;

                        while (true) {
                            try {
                                System.out.print("Enter date (DD-MM-YYYY): ");
                                date = LocalDate.parse(sc.nextLine(), formatter);
                                break;

                            } catch (DateTimeParseException e) {
                                System.out.println("Please enter a valid date.");
                            }
                        }

                        Expense expense = new Expense(nextId++, amount, category, date);
                        store.add(expense);

                        System.out.println("Expense added successfully!");
                        break;




                    //Viewing Expense
                    case 2:
                        if (store.isEmpty()) {
                            System.out.print("Expenses yet to be added...\n");
                            break;
                        }
                        for (Expense n : store) {
                            System.out.println(n);
                        }
                        break;

                    //Deleting expense
                    case 3:
                        try {
                            System.out.print("Enter the expense id: ");
                            int userInput = Integer.parseInt(sc.nextLine());
                            Expense temp = null;
                            for (Expense m : store) {
                                if (m.id() == userInput) {
                                    temp = m;
                                    break;
                                }
                            }
                            if (temp != null) {
                                store.remove(temp);
                                System.out.println("Expense deleted successfully.");
                            } else {
                                System.out.println("Expense ID not found.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a valid number.");
                        }
                        break;
                    case 4:
                        break menu;
                    default:
                        System.out.println("Enter a valid choice (1-4)");
                        break;
                }
            }
        sc.close();
    }
}