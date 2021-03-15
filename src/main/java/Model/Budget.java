package Model;

interface Budget {

    void addIncome(Income incomes);
    void addExpenses(Expense expenses);
    Income getIncomeInfo(int id);
    Expense getExpensesInfo(int id);
    int getTotalIncomeSum();
    int getTotalExpensesSum();


}
