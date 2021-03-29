package Model;

import service.BudgetService;

public class Record extends BudgetService implements UpdatableRecord {

    private static int counterId = 0;
    private final int id;
    private double sum;
    private String category;
    private String date;
    private String additionalInfo;


    public Record(double sum, String category, String date, String additionalInfo) {
        this.sum = sum;
        this.category = category;
        this.date = date;
        this.additionalInfo = additionalInfo;
        this.id = getCounterId();
        counterId++;
    }

    @Override
    public String toString() {
        return String.format("\n==========\nID = %d, Value = %.2f\nCategory = %s\nDate = %s\nadditional info: %s",
                id, sum, category, date, additionalInfo);
    }


    public static int getCounterId() {
        return counterId;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public double getSum() {
        return sum;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
