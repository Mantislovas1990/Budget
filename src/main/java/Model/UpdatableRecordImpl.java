package Model;

import Model.Enum.Category;

public class UpdatableRecordImpl implements UpdatableRecord {

    private double sum;
    private Category category;
    private String additionalInfo;

    public UpdatableRecordImpl(UpdatableRecord selectedRecord) {
        this.sum = selectedRecord.getSum();
        this.category = selectedRecord.getCategory();
        this.additionalInfo = selectedRecord.getAdditionalInfo();
    }

    public UpdatableRecordImpl() {
    }

    @Override
    public Double getSum() {
        return this.sum;
    }

    @Override
    public Category getCategory() {
        return this.category;
    }

    @Override
    public String getAdditionalInfo() {
        return this.additionalInfo;
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

    @Override
    public String toString() {
        return "CHOOSE UPDATABLE VALUE:\n[1] -> Update Sum: "+ sum+"\n[2] -> Update Category: " + category +"\n[3] -> Update Additional Info: " + additionalInfo;
    }
}
