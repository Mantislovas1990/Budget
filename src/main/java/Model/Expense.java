package Model;


import Model.Enum.Category;
import Model.Enum.MethodOfPayment;

public class Expense extends Record {

    private final MethodOfPayment methodOfPayment;

    public Expense(double sum, Category category, String date, String additionalInfo, MethodOfPayment methodOfPayment) {
        super(sum, category, date, additionalInfo);
        this.methodOfPayment = methodOfPayment;
    }

    @Override
    public String toString() {
        String output = "";
//        output += "EXPENSES INFORMATION: \n";
        output += super.toString();
        output += String.format("\nMETHOD OF PAYMENT: %s\n==========\n",
                methodOfPayment);

        return output;
    }


    public MethodOfPayment getMethodOfPayment() {
        return methodOfPayment;
    }


}
