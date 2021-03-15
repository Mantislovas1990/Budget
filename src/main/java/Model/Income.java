package Model;


public class Income extends BudgetImp {

    private static int counterId = 0;
    private int id;
    private double sum;
    private String date;
    private String category;
    private boolean toYourBankAccount;
    private String additionalInfo;

    public Income(double sum, String date, String category, boolean toYourBankAccount, String additionalInfo) {
        this.sum = sum;
        this.date = date;
        this.category = category;
        this.toYourBankAccount = toYourBankAccount;
        this.additionalInfo = additionalInfo;
        this.id = counterId;
        counterId++;
    }

    @Override
    public String toString() {
        return String.format("\n==========\nID = %d, Income = %.2f\nDate = %s\nCategory = %s\nTo your bank account = %s\nadditional info:  %s\n==========\n",
                id,sum, date, category, toYourBankAccount ? "Yes" : "No", additionalInfo);
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isToYourBankAccount() {
        return toYourBankAccount;
    }

    public void setToYourBankAccount(boolean toYourBankAccount) {
        this.toYourBankAccount = toYourBankAccount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getId() {
        return id;
    }

}
