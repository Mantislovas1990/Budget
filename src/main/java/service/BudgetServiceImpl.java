package service;

import Model.Expense;
import Model.Income;
import Model.Record;
import Model.UpdatableRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class BudgetServiceImpl implements BudgetService {

    private final List<Record> records = new ArrayList<>();

    @Override
    public void addRecord(Record record) {
        records.add(record);
    }

    @Override
    public List<Income> getIncomeInfo() {
        return records.stream()
                .filter(record -> record instanceof Income)
                .map(record -> (Income) record)
                .collect(Collectors.toList());
    }

    @Override
    public List<Expense> getExpensesInfo() {
        return records.stream()
                .filter(record -> {
                    return record instanceof Expense;
                })
                .map(record -> {
                    return (Expense) record;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Record> getRecordById(int id) {
        return records.stream()
                .filter(recordIdValue -> recordIdValue.getId() == id)
                .findAny();
    }

    @Override
    public List<Record> updateRecord(UpdatableRecord updatableRecord, int selectedId) {
        return records.stream()
                .filter(id -> id.getId() == selectedId)
                .peek(record -> {
                    if (updatableRecord.getSum() != null)
                        record.setSum(updatableRecord.getSum());
                    if (updatableRecord.getCategory() != null)
                        record.setCategory(updatableRecord.getCategory());
                    if(updatableRecord.getAdditionalInfo() != null)
                    record.setAdditionalInfo(updatableRecord.getAdditionalInfo());
                })
                .collect((Collectors.toList()));
    }

    @Override
    public List<Record> removeRecord(int id) {
        records.removeIf(record -> record.getId() == id);
        return records;
    }

    public double getBalance() {
        return totalIncomeSum() - totalExpenseSum();
    }

    public List<Record> allRecords() {
        return records;
    }

    public Double totalIncomeSum(){
        return records.stream()
                .filter(record -> record instanceof Income)
                .map(Record::getSum)
                .reduce((double) 0, Double::sum);

    }

    public Double totalExpenseSum(){
        return records.stream()
                .filter(record -> record instanceof Expense)
                .map(Record::getSum)
                .reduce((double) 0, Double::sum);

    }
}