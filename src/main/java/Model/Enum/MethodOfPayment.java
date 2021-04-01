package Model.Enum;

public enum MethodOfPayment {
    DEBIT_CARD(1),
    TRANSFER(2);

    private final int  methodOfPayment;

    MethodOfPayment(int method) {
        methodOfPayment = method;
    }

    public int getMethodOfPayment() {
        return methodOfPayment;
    }

    public static MethodOfPayment convert(int source) {
        for(MethodOfPayment mop : MethodOfPayment.values()) {
            if(mop.getMethodOfPayment() == source) {
                return mop;
            }
        }
        return null;
    }
}


