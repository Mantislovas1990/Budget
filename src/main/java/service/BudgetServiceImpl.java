package service;

import Model.Expense;
import Model.Income;
import Model.Record;
import Model.UpdatableRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO: write unit tests
public class BudgetServiceImpl implements BudgetService {


    private double totalIncomeSum = 0;
    private double totalExpensesSum = 0;

    private final List<Record> records = new ArrayList<>();

    @Override
    public void addRecord(Record record) {
        if (record instanceof Income) {
            totalIncomeSum += record.getSum();
        }
        if (record instanceof Expense) {
            totalExpensesSum += record.getSum();
        }
        records.add(record);
    }

    @Override
    public List<Income> getIncomeInfo() {
        return records.stream()
                .filter(record -> {
                    return record instanceof Income;
                })
                .map(record -> {
                    return (Income) record;
                })
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

    //TODO need to add Null exception in case return value is null
    //TODO rewrite method to Stream
    @Override
    public List<Record> updateRecord(UpdatableRecord updatableRecord, int selectedId) {
//        for(Record record : records){
//            if(record.getId() == selectedId){
//                record.setSum(updatableRecord.getSum());
//                record.setAdditionalInfo(updatableRecord.getAdditionalInfo());
//                record.setCategory(updatableRecord.getCategory());
//            }
//        }
//        return records;
        return records.stream()
                .filter(id -> id.getId() == selectedId)
                .peek(record -> {
                    record.setSum(updatableRecord.getSum());
                    record.setCategory(updatableRecord.getCategory());
                    record.setAdditionalInfo(updatableRecord.getAdditionalInfo());
                })
                .collect((Collectors.toList()));
    }

    @Override
    public List<Record> removeRecord(int id) {
        records.removeIf(record -> record.getId() == id);
        return records;
    }

    //TODO make a funcktion iterate trough all list ans with method instance of find all income sums and all expenses sum
    //TODO than subtract incomes - expenses and return difference as a balance
    public double getBalance() {
        return totalIncomeSum - totalExpensesSum;
    }

    public List<Record> allRecords() {
        return records;
    }

}