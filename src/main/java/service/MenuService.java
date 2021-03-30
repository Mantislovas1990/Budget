package service;

import Model.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuService {

    private final BudgetServiceImpl budgetServiceImpl;
    private final UpdatableRecordImpl updatableRecordImpl;

    public MenuService(BudgetServiceImpl budgetServiceImpl, UpdatableRecordImpl updatableRecordImpl) {
        this.budgetServiceImpl = budgetServiceImpl;
        this.updatableRecordImpl = updatableRecordImpl;
    }

    public void menuAddIncome(Scanner sc) {

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

        budgetServiceImpl.addRecord(new Income(sum, chooseCategory, date(), addInfo, toBank));
    }

    public void menuAddExpense(Scanner sc) {
        System.out.println("Enter the value of expense");
        double sum = sc.nextInt();

        System.out.println("Choose category:\n[1] = Private\n[2] = Local");
        String chooseCategory = category(sc.next());
        sc.nextLine();

        System.out.println("Please add additional info");
        String addInfo = sc.nextLine();

        System.out.println("Choose method of payment:\n[1] = Debit Card\n[2] = Transfer");
        int methodOfPayment = sc.nextInt();

        // TODO make method ENUM everywhere
        String method;
        if (methodOfPayment == 1) {
            method = "Debit Card";
        } else {
            method = "Transfer";
        }

        budgetServiceImpl.addRecord(new Expense(sum, chooseCategory, date(), addInfo, method));
    }

    //TODO add null checker
    public void menuUpdateRecord(Scanner sc) {
        System.out.println(budgetServiceImpl.allRecords());
        System.out.println("CHOOSE ID");
        int selectedId = sc.nextInt();
        UpdatableRecord selectedRecord = budgetServiceImpl.getRecordById(selectedId).orElseThrow(() -> new RuntimeException("Entered ID is not existing")); // TODO: Create entry not found exception and throw it here
        System.out.println(new UpdatableRecordImpl(selectedRecord));

        if (sc.next().equals("1")) {
            // set sum
            System.out.println("ENTER NEW VALUE");
            updatableRecordImpl.setSum(sc.nextInt());
        } else if (sc.next().equals("2")) {
            // update category if selected 2
            // set category
            System.out.println("ENTER NEW CATEGORY");
            updatableRecordImpl.setCategory(sc.nextLine());

        } else if (sc.next().equals("3")) {
            // update additional info
            // set additional
            System.out.println("ENTER NEW INFO");
            updatableRecordImpl.setAdditionalInfo(sc.nextLine());
        }
        System.out.println(budgetServiceImpl.updateRecord(updatableRecordImpl, selectedId));
    }

    public String date() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd  HH:mm");
        return dateFormat.format(currentDate);
    }


    // TODO: make category ENUM instead of string everywhere
    public String category(String value) {

        String category;
        if (value.equals("1")) {
            category = "Private";
        } else {
            category = "Local";
        }
        return category;
    }

    public int action(int value) {
        if (value == 1 || value == 2 || value == 3 ||
                value == 4 || value == 5 || value == 6 || value == 7 || value == 8) {
            return value;
        }
        return -1;
    }


    // TODO: make it return string
    public String addIncomeOrExpense(Scanner sc) {
        System.out.println("[1] -> Add Income\n[2] -> Add Expense ");
        if (sc.next().equals("1")) {
            menuAddIncome(sc);
        } else if (sc.next().equals("2")) {
            menuAddExpense(sc);
        }
        return "";
    }

    // TODO: make it return string
    public void prepareSummary(String next) {
        System.out.println("[1] -> Income Summary\n[2] -> Expense Summary ");
        if (next.equals("1")) {
            System.out.println(budgetServiceImpl.getIncomeInfo());

        } else if (next.equals("2")) {
            System.out.println(budgetServiceImpl.getExpensesInfo());

        }
    }
}

