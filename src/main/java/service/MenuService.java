package service;

import Model.*;
import Model.Enum.Category;
import Model.Enum.MethodOfPayment;
import exception.EntryNotFoundException;


import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    private final BudgetServiceImpl budgetServiceImpl;
    private final UpdatableRecordImpl updatableRecordImpl;

    public MenuService(BudgetServiceImpl budgetServiceImpl, UpdatableRecordImpl updatableRecordImpl) {
        this.budgetServiceImpl = budgetServiceImpl;
        this.updatableRecordImpl = updatableRecordImpl;
    }


    public void menuAddIncome(Scanner sc) {

        System.out.println("ENTER INCOME VALUE");
        double sum = sc.nextInt();

        System.out.println("CHOOSE CATEGORY:\n[1] -> PRIVATE\n[2] -> LOCAL");
        Category chooseCategory = category(sc);
        sc.nextLine();

        System.out.println("ADDITIONAL INFO 'OPTIONAL'");
        String addInfo = sc.nextLine();

        System.out.println("DO YOU WANT TRANSFER MONEY TO BANK ACCOUNT?\n[1] -> YES\n[2] -> NO");
        int bank = sc.nextInt();
        boolean toBank;
        toBank = bank == 1;

        budgetServiceImpl.addRecord(new Income(sum, chooseCategory, date(), addInfo, toBank));
    }

    //TODO FIND OUT WHY USER HAVE TO TYPE VALUE 2 TIMES BEFORE ENTERING VALUE
    public void menuAddExpense(Scanner sc) {

        System.out.println("ENTER EXPENSE VALUE");
        double sum = sc.nextInt();

        System.out.println("CHOOSE CATEGORY:\n[1] -> PRIVATE\n[2] -> LOCAL");
        Category chooseCategory = category(sc);
        sc.nextLine();

        System.out.println("ADDITIONAL INFO 'OPTIONAL'");
        String addInfo = sc.nextLine();

        System.out.println("METHOD OF PAYMENT:\n[1] -> DEBIT CARD\n[2] -> TRANSFER");

        //ADDED NEW ENUM METHOD ===NEED TO CHECK WITH ELVIU===
        MethodOfPayment methodOfPayment = MethodOfPayment.valueOf(sc.nextInt());


        // TODO make method ENUM everywhere
//        String method;
//        if (methodOfPayment == 1) {
//            method = "DEBIT CARD";
//        } else {
//            method = "TRANSFER";
//        }

        budgetServiceImpl.addRecord(new Expense(sum, chooseCategory, date(), addInfo, methodOfPayment));
    }

    //TODO add null checker
    public void menuUpdateRecord(Scanner sc) {
        System.out.println(budgetServiceImpl.allRecords());
        System.out.println("CHOOSE ID");
        int selectedId = sc.nextInt();
        UpdatableRecord selectedRecord = budgetServiceImpl.getRecordById(selectedId).orElseThrow(EntryNotFoundException::new); // TODO: Create entry not found exception and throw it here
        System.out.println(new UpdatableRecordImpl(selectedRecord));

        if (sc.next().equals("1")) {
            // set sum
            System.out.println("ENTER NEW VALUE");
            updatableRecordImpl.setSum(sc.nextInt());
        } if (sc.next().equals("2")) {
            // update category if selected 2
            // set category
            updatableRecordImpl.setCategory(category(sc));

        } if (sc.next().equals("3")) {
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
    public Category category(Scanner sc) {
        System.out.println("CHOOSE CATEGORY:\n[1] -> PRIVATE\n[2] -> LOCAL");
        if (sc.next().equals("1")) {
            return Category.PRIVATE;
        } else {
            return Category.LOCAL;
        }

    }

    public int action(int value) {
        if (value == 1 || value == 2 || value == 3 ||
                value == 4 || value == 5 || value == 6 || value == 7 || value == 8) {
            return value;
        }
        return -1;
    }


    // TODO: make it return string // Do we actually need to return String when we don't have to return anything?
    public void addIncomeOrExpense(Scanner sc) {
        System.out.println("[1] -> ADD INCOME\n[2] -> ADD EXPENSE ");
        if (sc.next().equals("1")) {
           menuAddIncome(sc);
        } else {
           menuAddExpense(sc);
        }
    }

    // TODO: make it return string //
    public List<? extends Record> prepareSummary(Scanner sc) {
        System.out.println("[1] -> INCOME SUMMARY\n[2] -> EXPENSE SUMMARY ");
        if (sc.next().equals("1")) {
            return budgetServiceImpl.getIncomeInfo();
        } else {
            return budgetServiceImpl.getExpensesInfo();
        }
    }
}


