package Model;

public class UpdatableRecordImpl implements UpdatableRecord{

    private double sum;
    private String category;
    private String additionalInfo;

    public UpdatableRecordImpl(UpdatableRecord selectedRecord) {
        this.sum = selectedRecord.getSum();
        this.category = selectedRecord.getCategory();
        this.additionalInfo = selectedRecord.getAdditionalInfo();
    }

    public UpdatableRecordImpl() {
    }

    @Override
    public double getSum() {
        return this.sum;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public String getAdditionalInfo() {
        return this.additionalInfo;
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

    @Override
    public String toString() {
        return "CHOOSE UPDATABLE VALUE:\n[1] -> Update Sum: "+ sum+"\n[2] -> Update Category: " + category +"\n[3] -> Update Additional Info: " + additionalInfo;
    }
}
