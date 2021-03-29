package Model.Menu;


import Model.UpdatableRecord;
import Model.UpdatableRecordImpl;
import service.BudgetService;

import java.util.Scanner;

public class Menu {

    public static void run() {

        Scanner sc = new Scanner(System.in);

        BudgetService budgetService = new BudgetService();
        UpdatableRecordImpl updatableRecordImpl = new UpdatableRecordImpl();
        ;


        String menu = ("\nPlease choose the action:\n---------------------\n[1] = Current Balance\n[2] = Add Income/Expense \n[3] = Get " +
                "Income/Expense Summary  \n[4] = Update Values \n[5] = Save Data File\n[6] = Get Data File\n[7] = Delete Record\n[8] = Close the program\n---------------------");

        boolean run = true;

        while (run) {
            System.out.println(menu);

            boolean hasNextInt = sc.hasNextInt();

            if (hasNextInt) {
                int chooseAction = MenuMethods.action(sc.nextInt());
                switch (chooseAction) {
                    case 1:
                        System.out.println(budgetService.getBalance());
                        break;

                    case 2:
                        System.out.println("[1] -> Add Income\n[2] -> Add Expense ");

                        if (sc.next().equals("1")) {
                            MenuMethods.menuAddIncome();
                        } else {
                            MenuMethods.menuAddExpense();
                        }
                        break;

                    case 3:
                        System.out.println("[1] -> Income Summary\n[2] -> Expense Summary ");

                        if (sc.next().equals("1")) {
                            System.out.println(budgetService.getIncomeInfo());
                        } else {
                            System.out.println(budgetService.getExpensesInfo());
                        }
                        break;

                    case 4:
                        //TODO find solution how to use ID entered by user to GET etc. SUM and set new Value.
                        budgetService.allRecords();
                        System.out.println("CHOOSE ID");
                        int selectedId = sc.nextInt();
                        UpdatableRecord selectedRecord = budgetService.getRecordById(selectedId).orElseThrow(() -> new RuntimeException("Entered ID is not existing")); // TODO: Create entry not found exception and throw it here
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
                        // update setted values
                        // you should have a updatableRecordImpl here
                        // you should pass it to a !!service!! and change value of selected id
                        // get by id -> record.setSum(updatedRecord.getSum() -> make sure that its in a list
                        // show updated records. you can use sout(service.updateRecord(updatedRecord)) or smth like this
                        System.out.println(budgetService.updateRecord(updatableRecordImpl, selectedId));
                        break;

                    case 5:

                        break;

                    case 6:

                        break;

                    case 7:
                        budgetService.allRecords();
                        System.out.println("ENTER ID");
                        budgetService.removeRecord(sc.nextInt());
                        break;
                    case 8:
                        run = false;
                        System.out.println("\nProgram is closing................\n=====================\nHave a Great Day!.");
                        break;
                    default:
                        System.out.println("ERROR!\n==============\nUnrecognised Input!");
                        break;
                }
            } else {
                System.out.println("\nERROR! UNKNOWN COMMAND!");
            }

            sc.nextLine();
            // sc.close();
        }
    }
}

