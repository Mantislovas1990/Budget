package model.budget;

import model.Enum.Category;

public class Record  implements UpdatableRecord {

    private static int counterId = 0;
    private int id;
    private double sum;
    private Category category;
    private String date;
    private String additionalInfo;
    private  String type;


    public Record(String type, double sum, Category category, String date, String additionalInfo) {
        this.sum = sum;
        this.category = category;
        this.date = date;
        this.additionalInfo = additionalInfo;
        this.id = getCounterId();
        counterId++;
        this.type = type;
    }

    public Record(){}

    @Override
    public String toString() {
        return String.format("%n==========%nID = %d, VALUE = %.2f%nCATEGORY: %s%nDATE: %s%nADDITIONAL INFO: %s",
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
    public Double getSum() {
        return sum;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getType() {
        return type;
    }


}
