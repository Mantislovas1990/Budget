package Model;


public class Expense extends BudgetImp{

    private static int counterId = 0;
    private int id;
    private double sum;
    private String category;
    private String date;
    private String methodOfPayment;
    private String additionalInfo;

    public Expense(double sum, String category, String dateAndTime, String methodOfPayment, String additionalInfo) {
        this.sum = sum;
        this.category = category;
        this.date = dateAndTime;
        this.methodOfPayment = methodOfPayment;
        this.additionalInfo = additionalInfo;
        this.id = counterId;
        counterId++;
    }

    @Override
    public String toString() {
        return String.format("\n==========\nID = %d, Expense = %.2f\n Category = %s\nDate = %s\nMethod of payment = %s\nadditional info: %s\n==========\n",
                id, sum, category,date, methodOfPayment, additionalInfo);
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateAndTime() {
        return date;
    }

    public void setDateAndTime(String dateAndTime) {
        this.date = dateAndTime;
    }

    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
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
