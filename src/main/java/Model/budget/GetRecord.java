package Model.budget;

import Model.Expense;
import Model.Income;
import Model.Record;

import java.util.List;
import java.util.Optional;

public interface GetRecord {
    List<Income> getIncomeInfo();
    List<Expense> getExpensesInfo();
    Optional<Record> getRecordById(int id);
}
