package Model;

public class BudgetImp implements Budget {

    private int totalIncomeSum = 0;
    private int totalExpensesSum =0;
    private int incomeCounter = 0;
    private int expenseCounter = 0;

    private static Income[] incomes = new Income[100];
    private static Expense[] expenses = new Expense[100];

    @Override
    public void addIncome(Income income) {
        incomes[incomeCounter] = income;
        incomeCounter++;
        totalIncomeSum += income.getSum();
    }

    @Override
    public void addExpenses(Expense expense) {
        expenses[expenseCounter] = expense;
        expenseCounter++;
        totalExpensesSum += expense.getSum();
    }

    @Override
    public Income getIncomeInfo(int id) {
        for (Income income : incomes) {
            if (income.getId() == id) {
                return income;
            }
        }
        return null;
    }

    @Override
    public Expense getExpensesInfo(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        return null;
    }

    @Override
    public int getTotalIncomeSum() {
        return totalIncomeSum;
    }

    @Override
    public int getTotalExpensesSum() {
        return totalExpensesSum;
    }
}