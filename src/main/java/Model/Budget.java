package Model;

import java.util.List;

interface Budget {

    void addIncome(Income incomes);
    void addExpenses(Expense expenses);
    List<Income> getIncomeInfo();
    List<Expense> getExpensesInfo();
    double getBalance();
    List<Income> removeIncome(int id);
    List<Expense> removeExpense(int id);


}
