package Model;


public class Income extends Record {

    private final boolean toYourBankAccount;

    public Income(double sum, String category, String date, String additionalInfo, boolean toYourBankAccount) {
        super(sum, category, date, additionalInfo);
        this.toYourBankAccount = toYourBankAccount;
    }

    @Override
    public String toString() {
        String output = "";
//        output += "INCOME INFORMATION: \n";
        output += super.toString();
        output += String.format("\nTo your bank account = %s\n==========\n",
                toYourBankAccount ? "Yes" : "No");

        return output;
    }


    public boolean isToYourBankAccount() {
        return toYourBankAccount;
    }

}
