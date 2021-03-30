package service;

import Model.Expense;
import Model.Income;
import Model.Record;
import Model.UpdatableRecord;

import java.util.List;
import java.util.Optional;

public interface BudgetService {

    void addRecord(Record record);
    List<Record> removeRecord(int id);
    List<Record> updateRecord(UpdatableRecord updatableRecord, int selectedId);
    List<Income> getIncomeInfo();
    List<Expense> getExpensesInfo();
    Optional<Record> getRecordById(int id);

}
