package Model.Menu;

import Model.Expense;
import Model.Income;
import service.BudgetService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuMethods {

    static BudgetService budgetService = new BudgetService();
    static Scanner sc = new Scanner(System.in);

    //TODO check why balance is not showing after menuAddIncome execution
    public static void menuAddIncome() {

        System.out.println("Enter the value of income");
        double sum = sc.nextInt();

        System.out.println("Choose category of added Income:\n[1] = Private\n[2] = Local");
        String chooseCategory = category(sc.next());
        sc.nextLine();
        System.out.println("Please add additional info");
        String addInfo = sc.nextLine();

        System.out.println("Have you transferred money to your Bank Account?\n[1] = YES\n[2] = NO");
        int bank = sc.nextInt();
        boolean toBank;
        toBank = bank == 1;

        budgetService.addRecord(new Income(sum, chooseCategory, date(), addInfo, toBank));
    }

    public static void menuAddExpense() {
        System.out.println("Enter the value of expense");
        double sum = sc.nextInt();

        System.out.println("Choose category of :\n[1] = Private\n[2] = Local");
        String chooseCategory = category(sc.next());

        System.out.println("Please add additional info");
        String addInfo = sc.nextLine();

        System.out.println("Choose method of payment:\n[1] = Debit Card\n[2] = Transfer");
        int methodOfPayment = sc.nextInt();

        String method;
        if (methodOfPayment == 1) {
            method = "Debit Card";
        } else {
            method = "Transfer";
        }

        budgetService.addRecord(new Expense(sum, chooseCategory, date(), addInfo, method));
    }

    public static String date() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd  HH:mm");
        return dateFormat.format(currentDate);
    }


    public static String category(String value) {
        String category;
        if (value.equals("1")) {
            category = "Private";
        } else {
            category = "Local";
        }
        return category;
    }

    public static int action(int value) {
        if (value == 1 || value == 2 || value == 3 ||
                value == 4 || value == 5 || value == 6) {
            return value;
        }
        return -1;
    }


}

