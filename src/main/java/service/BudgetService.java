package service;

import model.budget.Expense;
import model.budget.Income;
import model.budget.Record;
import model.budget.UpdatableRecord;

import java.util.List;
import java.util.Optional;

public interface BudgetService {

    void addRecord(Record record);
    List<Record> removeRecord(int id);
    List<Record> updateRecord(UpdatableRecord updatableRecord, int selectedId);
    List<Income> getIncomeInfo();
    List<Expense> getExpensesInfo();
    Optional<Record> getRecordById(int id);
    Double totalIncomeSum();
    Double totalExpenseSum();
    double getBalance();

}
