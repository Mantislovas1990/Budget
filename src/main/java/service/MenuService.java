package service;

import exception.EntryNotFoundException;
import model.Enum.Category;
import model.Enum.MethodOfPayment;
import model.budget.*;

import java.util.List;
import java.util.Scanner;

import static util.DateTime.date;

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

        Category chooseCategory = category(sc);
        sc.nextLine();

        System.out.println("ADDITIONAL INFO 'OPTIONAL'");
        String addInfo = sc.nextLine();

        System.out.println("DO YOU WANT TRANSFER MONEY TO BANK ACCOUNT?\n[1] -> YES\n[2] -> NO");
        int bank = sc.nextInt();
        boolean toBank = bank == 1;

        budgetServiceImpl.addRecord(new Income("Income",sum, chooseCategory, date(), addInfo, toBank));
    }

    public void menuAddExpense(Scanner sc) {

        System.out.println("ENTER EXPENSE VALUE");
        double sum = sc.nextInt();

        Category chooseCategory = category(sc);
        sc.nextLine();

        System.out.println("ADDITIONAL INFO 'OPTIONAL'");
        String addInfo = sc.nextLine();

        System.out.println("METHOD OF PAYMENT:\n[1] -> DEBIT CARD\n[2] -> TRANSFER");

        MethodOfPayment methodOfPayment = MethodOfPayment.convert(sc.nextInt());

        budgetServiceImpl.addRecord(new Expense("Expense",sum, chooseCategory, date(), addInfo, methodOfPayment));
    }

    public void menuUpdateRecord(Scanner sc) {
        System.out.println(budgetServiceImpl.getAllRecords());
        System.out.println("CHOOSE ID");
        int selectedId = sc.nextInt();
        UpdatableRecord selectedRecord = budgetServiceImpl.getRecordById(selectedId).orElseThrow(EntryNotFoundException::new);
        System.out.println(new UpdatableRecordImpl(selectedRecord));

        if (sc.next().equals("1")) {
            System.out.println("ENTER NEW VALUE");
            updatableRecordImpl.setSum(sc.nextInt());
        } else if (sc.next().equals("2")) {
            updatableRecordImpl.setCategory(category(sc));

        } else if (sc.next().equals("3")) {
            System.out.println("ENTER NEW INFO");
            updatableRecordImpl.setAdditionalInfo(sc.nextLine());
        }
        System.out.println(budgetServiceImpl.updateRecord(updatableRecordImpl, selectedId));
    }


    public Category category(Scanner sc) {
        System.out.println("CHOOSE CATEGORY:\n[1] -> PRIVATE\n[2] -> LOCAL");
        if (sc.next().equals("1")) {
            return Category.PRIVATE;
        }
        return Category.LOCAL;
    }

    public int action(int value) {
        if (value == 1 || value == 2 || value == 3 || value == 4 || value == 5 || value == 6 || value == 7 || value == 8) {
            return value;
        }
        return -1;
    }

    public void addIncomeOrExpense(Scanner sc) {
        System.out.println("[1] -> ADD INCOME\n[2] -> ADD EXPENSE ");
        if (sc.next().equals("1")) {
            menuAddIncome(sc);
        } else {
            menuAddExpense(sc);
        }
    }

    public List<? extends Record> prepareSummary(Scanner sc) {
        System.out.println("[1] -> INCOME SUMMARY\n[2] -> EXPENSE SUMMARY ");
        if (sc.next().equals("1")) {
            return budgetServiceImpl.getIncomeInfo();
        }
        return budgetServiceImpl.getExpensesInfo();
    }
}


