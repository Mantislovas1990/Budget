package model.budget;


import model.Enum.Category;

public class Income extends Record {

    private final boolean toYourBankAccount;

    public Income(String type, double sum, Category category, String date, String additionalInfo, boolean toYourBankAccount) {
        super(type,sum, category, date, additionalInfo);
        this.toYourBankAccount = toYourBankAccount;
    }

    @Override
    public String toString() {
        String output = "";
        output += super.toString();
        output += String.format("%nTO YOUR BANK ACCOUNT: %s%n==========%n",
                toYourBankAccount ? "YES" : "NO");

        return output;
    }

    public boolean isToYourBankAccount() {
        return toYourBankAccount;
    }

}
