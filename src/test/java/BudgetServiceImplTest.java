import model.Enum.Category;
import model.Enum.MethodOfPayment;
import model.budget.Expense;
import model.budget.Income;
import model.budget.Record;
import model.budget.UpdatableRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.BudgetServiceImpl;
import util.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BudgetServiceImplTest {

    Record firstIncome = new Income("Income", 1000, Category.PRIVATE, DateTime.date(), "FistIncome", true);
    Record secondIncome = new Income("Income", 1000, Category.PRIVATE, DateTime.date(), "SecondIncome", true);
    Record firstExpense = new Expense("Expense", 1000, Category.PRIVATE, DateTime.date(), "FirstExpense", MethodOfPayment.DEBIT_CARD);

    BudgetServiceImpl service = new BudgetServiceImpl();

    @BeforeEach
    void init() {
        service.setRecords(new ArrayList<>());
        service.addRecord(firstIncome);
        service.addRecord(secondIncome);
        service.addRecord(firstExpense);
    }

    @AfterEach
    void teardown() {
        service.setRecords(new ArrayList<>());
        service.addRecord(firstIncome);
        service.addRecord(secondIncome);
        service.addRecord(firstExpense);

    }

    @Test
    void addRecordTest() {
        assertEquals(3, service.getAllRecords().size());
    }

    @Test
    void getIncomeInfoTest() {
        List<Income> inc = service.getIncomeInfo();

        assertEquals(2, inc.size());

    }

    @Test
    void getExpenseInfoTest() {
        List<Expense> inc = service.getExpensesInfo();

        assertEquals(1, inc.size());
    }


    @Test
    void getRecordByIdTest() {
        Optional<Record> testRecord = service.getRecordById(13);
        Optional<Record> expected = service.getRecordById(secondIncome.getId());
        assertEquals(expected, testRecord);
    }

    @Test
    void getBalanceTest() {
        double balance = service.getBalance();

        assertEquals(1000, balance);
    }

    @Test
    void removeRecord() {
        List<Record> removeRecord = service.removeRecord(1);
        int afterRemove = service.getAllRecords().size();

        assertEquals(afterRemove, removeRecord.size());
    }

    private static class UpdatableRecordTestImpl implements UpdatableRecord {

        @Override
        public Double getSum() {
            return 200.00;
        }

        @Override
        public Category getCategory() {
            return Category.PRIVATE;
        }

        @Override
        public String getAdditionalInfo() {
            return "jajaja";
        }

    }

    @Test
    void updateRecordTest() {
        service.updateRecord(new UpdatableRecordTestImpl(), 10);
        double balance =  service.getBalance();
        assertEquals(200, balance);

        Category updatedCategory = service.getRecordById(10).get().getCategory();
        assertEquals(Category.PRIVATE,updatedCategory);

        String updatedInfo = service.getRecordById(10).get().getAdditionalInfo();
        assertEquals("jajaja", updatedInfo);
    }

}



