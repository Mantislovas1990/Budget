package Model;


import Model.Enum.Category;

public class Income extends Record {

    private final boolean toYourBankAccount;

    public Income(double sum, Category category, String date, String additionalInfo, boolean toYourBankAccount) {
        super(sum, category, date, additionalInfo);
        this.toYourBankAccount = toYourBankAccount;
    }

    @Override
    public String toString() {
        String output = "";
//        output += "INCOME INFORMATION: \n";
        output += super.toString();
        output += String.format("\nTO YOUR BANK ACCOUNT: %s\n==========\n",
                toYourBankAccount ? "YES" : "NO");

        return output;
    }


    public boolean isToYourBankAccount() {
        return toYourBankAccount;
    }

}
