import model.Enum.Category;
import model.Enum.MethodOfPayment;
import model.budget.Expense;
import model.budget.Income;
import model.budget.Record;
import org.junit.jupiter.api.Test;
import util.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetServiceImplTest {

    List<Record> records = new ArrayList<>();

    Record firstIncome = new Income("Income", 1000, Category.PRIVATE, DateTime.date(), "FistIncome", true);
    Record secondIncome = new Income("Income", 1000, Category.PRIVATE, DateTime.date(), "SecondIncome", true);
    Record firstExpense = new Expense("Expense", 1000, Category.PRIVATE, DateTime.date(), "FirstExpense", MethodOfPayment.DEBIT_CARD);

    BudgetServiceImplTest(){
        records.add(firstIncome);
        records.add(secondIncome);
        records.add(firstExpense);

    }

    @Test
    void addRecordTest() {
        assertEquals(3, records.size());
    }

    @Test
    void getIncomeInfoTest() {
        List<Record> inc = records.stream()
                .filter(record -> record instanceof Income)
                .map(Income.class::cast)
                .collect(Collectors.toList());

        assertEquals(2, inc.size());

    }

    @Test
    void getExpenseInfoTest() {
        List<Record> exp = records.stream()
                .filter(record -> record instanceof Expense)
                .map(Expense.class::cast)
                .collect(Collectors.toList());

        assertEquals(1, exp.size());

    }

    @Test
    void getRecordByIdTest() {

        List<Record> id = records.stream()
                .filter(recordIdValue -> recordIdValue.getId() == 1)
                .collect(Collectors.toList());

        System.out.println(records + "byId");

        assertEquals(1, id.size());

    }

    @Test
    void getBalanceTest() {

        double inc = records.stream()
                .filter(record -> record instanceof Income)
                .map(Record::getSum)
                .reduce((double) 0, Double::sum);

        double exp = records.stream()
                .filter(record -> record instanceof Expense)
                .map(Record::getSum)
                .reduce((double) 0, Double::sum);

        double balance = inc - exp;

        assertEquals(1000, balance);
    }

//     void FillAList(){
//        List<Record> records = new ArrayList<>();
//        fillList(records,3);
//    }
//
//    private void fillList(List<Record> records, int i) {
//        for(int x=0; x<i;x++){
//            records.add(new Income("Income", 1000, Category.PRIVATE, DateTime.date(), "FistIncome", true));
//        }
//    }

}
