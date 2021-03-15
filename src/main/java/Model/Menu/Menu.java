package Model.Menu;


import Model.BudgetImp;
import Model.Expense;
import Model.Income;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        BudgetImp budgetImp = new BudgetImp();

        String menu = ("\nPlease choose the action:\n---------------------\n[1] = Current Balance\n[2] = Check Income info\n[3] = Check " +
                "Expense info\n[4] = Add new Income\n[5] = Add new Expense\n[6] = Close the program\n---------------------");

        boolean run = true;

        while (run) {
            System.out.println(menu);

            boolean hasNextInt = sc.hasNextInt();

            if (hasNextInt) {
                int chooseAction = sc.nextInt();

                if (chooseAction == 1 || chooseAction == 2 || chooseAction == 3 ||
                        chooseAction == 4 || chooseAction == 5 || chooseAction == 6) {
                    String category;
                    switch (chooseAction) {
                        case 1:
                            break;
                        case 2:
                            System.out.println(budgetImp.getTotalIncomeSum());;
                            break;
                        case 3:
                            System.out.println(budgetImp.getTotalExpensesSum());
                            break;
                        case 4:

                            System.out.println("Enter the value of income");
                            double inc = sc.nextInt();

                            System.out.println("Choose category of added Income:\n[1] = Private\n[2] = Local");
                            int chooseCategory = sc.nextInt();

                            if (chooseCategory == 1) {
                                category = "Private";
                            } else {
                                category = "Local";
                            }

                            System.out.println("Have you transferred money to your Bank Account?\n[1] = YES\n[2] = NO");
                            int bank = sc.nextInt();

                            boolean toBank;
                            if (bank == 1) {
                                toBank = true;
                            } else {
                                toBank = false;
                            }

                            System.out.println("Please add additional info");
                            String addInfo = sc.nextLine();

                            Date currentDate = new Date();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd  HH:mm");
                            String date = dateFormat.format(currentDate);

                            Income income = new Income(inc, date, category, toBank, addInfo);
                            budgetImp.addIncome(income);
                            break;

                        case 5:
                            System.out.println("Enter the value of expense");
                            double exp = sc.nextInt();

                            System.out.println("Choose category of :\n[1] = Private\n[2] = Local");
                            chooseCategory = sc.nextInt();

                            if (chooseCategory == 1) {
                                category = "Private";
                            } else {
                                category = "Local";
                            }

                            System.out.println("Choose method of payment:\n[1] = Debit Card\n[2] = Transfer");
                            int methodOfPayment = sc.nextInt();

                            String method;
                            if (methodOfPayment == 1) {
                                method = "Debit Card";
                            } else {
                                method = "Transfer";
                            }

                            System.out.println("Please add additional info");
                            addInfo = sc.nextLine();

                            currentDate = new Date();
                            dateFormat = new SimpleDateFormat("yy/MM/dd");
                            date = dateFormat.format(currentDate);

                            budgetImp.addExpenses(new Expense(exp, date, category, method, addInfo));
                            break;
                        case 6:
                            run = false;
                            System.out.println("\nProgram is closing................\n=====================\nHave a Great Day!.");
                            break;
                    }
                } else {
                    System.out.println("\nERROR! UNKNOWN COMMAND!");
                }

            } else {
                System.out.println("ERROR!\n==============\nUnrecognised Input!");
            }
            sc.nextLine();
            // sc.close();
        }
    }
}

