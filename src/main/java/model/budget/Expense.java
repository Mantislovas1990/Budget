package model.budget;


import model.Enum.Category;
import model.Enum.MethodOfPayment;

public class Expense extends Record {

    private final MethodOfPayment methodOfPayment;

    public Expense(String type, double sum, Category category, String date, String additionalInfo, MethodOfPayment methodOfPayment) {
        super(type,sum, category, date, additionalInfo);
        this.methodOfPayment = methodOfPayment;
    }

    @Override
    public String toString() {
        String output = "";
        output += super.toString();
        output += String.format("%nMETHOD OF PAYMENT: %s%n==========%n",
                methodOfPayment);

        return output;
    }


    public MethodOfPayment getMethodOfPayment() {
        return methodOfPayment;
    }

}
