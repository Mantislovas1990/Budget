package Model.Menu;


import Model.UpdatableRecordImpl;
import service.BudgetServiceImpl;
import service.MenuService;

import java.util.Scanner;

public class Menu {

    private final BudgetServiceImpl budgetServiceImpl = new BudgetServiceImpl();
    private final UpdatableRecordImpl updatableRecordImpl = new UpdatableRecordImpl();
    private final MenuService menuService = new MenuService(budgetServiceImpl, updatableRecordImpl);

    public void run() {

        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println(getMenuText());

            boolean hasNextInt = sc.hasNextInt();

            if (hasNextInt) {
                int chooseAction = menuService.action(sc.nextInt());
                switch (chooseAction) {
                    case 1:
                        System.out.println(budgetServiceImpl.getBalance());
                        break;

                    case 2:
                        menuService.addIncomeOrExpense(sc);
                        break;

                    case 3:
                        menuService.prepareSummary(sc.nextLine());
                        break;

                    case 4:
                        menuService.menuUpdateRecord(sc);
                        break;

                    case 5:

                        break;

                    case 6:

                        break;

                    case 7:
                        System.out.println(budgetServiceImpl.allRecords());
                        System.out.println("ENTER ID");
                        budgetServiceImpl.removeRecord(sc.nextInt());
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

    private String getMenuText() {
        return "\nPlease choose the action:\n---------------------\n[1] = Current Balance\n[2] = Add Income/Expense \n[3] = Get " +
                "Income/Expense Summary  \n[4] = Update Values \n[5] = Save Data To File\n[6] = Get Data From File\n[7] = Delete Record\n[8] = Close the program\n---------------------";
    }
}

