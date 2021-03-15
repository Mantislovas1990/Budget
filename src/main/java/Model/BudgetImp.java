package Model;

import java.util.ArrayList;
import java.util.List;

public class BudgetImp implements Budget {

    private double balance = 0;
    private double totalIncomeSum = 0;
    private double totalExpensesSum = 0;

    private static List<Income> incomes = new ArrayList<>();
    private static List<Expense> expenses = new ArrayList<>();

    @Override
    public void addIncome(Income income) {
        incomes.add(income);
        totalIncomeSum += income.getSum();
    }

    @Override
    public void addExpenses(Expense expense) {
        expenses.add(expense);
        totalExpensesSum += expense.getSum();
    }

    @Override
    public List<Income> getIncomeInfo() {
        return incomes;
    }

    @Override
    public List<Expense> getExpensesInfo() {
        return expenses;
    }


    @Override
    public double getBalance() {
        balance = totalIncomeSum - totalExpensesSum;
        return balance;
    }

    @Override
    public List<Income> removeIncome(int id) {
        for (Income income : incomes) {
            if (income.getId() == id) {
                incomes.remove(id);
                totalIncomeSum-= income.getSum();
            }
        }
        return null;
    }

    @Override
    public List<Expense> removeExpense(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                expenses.remove(id);
                totalExpensesSum-= expense.getSum();

            }
        }
        return null;
    }
}