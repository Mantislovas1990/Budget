package Model;


import Model.Enum.Category;

public class Expense extends Record {

    private final String methodOfPayment;

    public Expense(double sum, String category, String date, String additionalInfo, String methodOfPayment) {
        super(sum, category, date, additionalInfo);
        this.methodOfPayment = methodOfPayment;
    }

    @Override
    public String toString() {
        String output = "";
//        output += "EXPENSES INFORMATION: \n";
        output += super.toString();
        output += String.format("\nMethod of payment = %s\n==========\n",
                methodOfPayment);

        return output;
    }


    public String getMethodOfPayment() {
        return methodOfPayment;
    }


}
