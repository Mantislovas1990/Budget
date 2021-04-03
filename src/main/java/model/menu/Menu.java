package model.menu;


import model.budget.UpdatableRecordImpl;
import model.jason_serializer.load.LoadRecord;
import model.jason_serializer.save.SaveRecord;
import service.BudgetServiceImpl;
import service.MenuService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private final LoadRecord loadRecord = new LoadRecord();
    private final SaveRecord saveRecord = new SaveRecord();
    private final BudgetServiceImpl budgetServiceImpl = new BudgetServiceImpl();
    private final UpdatableRecordImpl updatableRecordImpl = new UpdatableRecordImpl();
    private final MenuService menuService = new MenuService(budgetServiceImpl, updatableRecordImpl);

    public void run() throws IOException {

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
                        System.out.println(menuService.prepareSummary(sc));
                        break;
                    case 4:
                        menuService.menuUpdateRecord(sc);
                        break;
                    case 5:
                        saveRecord.saveRecordsToFile(budgetServiceImpl);
                        break;
                    case 6:
                        budgetServiceImpl.setRecords(loadRecord.loadRecordsFromFile());
                        break;
                    case 7:
                        System.out.println(budgetServiceImpl.getAllRecords());
                        System.out.println("ENTER ID");
                        budgetServiceImpl.removeRecord(sc.nextInt());
                        break;
                    case 8:
                        run = false;
                        System.out.println("\nPROGRAM IS CLOSING................\n=====================\nHAVE A GREAT DAY!");
                        break;
                    default:
                        System.out.println("ERROR!\n==============\nUNRECOGNISED INPUT!");
                        break;
                }
            } else {
                System.out.println("\nERROR! UNKNOWN COMMAND!");
            }

            sc.nextLine();
        }
    }

    private String getMenuText() {
        return "\nCHOOSE ACTION:\n---------------------\n[1] -> CURRENT BALANCE\n[2] -> ADD INCOME / EXPENSE \n[3] -> GET " +
                "INCOME / EXPENSE SUMMARY  \n[4] -> UPDATE VALUES \n[5] -> SAVE DATA TO FILE\n[6] -> GET DATA FROM FILE\n[7] -> DELETE RECORD\n[8] -> CLOSE THE PROGRAM\n---------------------";
    }
}

