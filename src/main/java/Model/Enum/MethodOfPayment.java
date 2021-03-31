package Model.Enum;

import java.util.HashMap;
import java.util.Map;

public enum MethodOfPayment {
    DEBIT_CARD(1),
    TRANSFER(2);

    private final int  methodOfPayment;

    private static final Map<Integer, MethodOfPayment> map = new HashMap<>();

    static   {
        for (MethodOfPayment methodEnum : MethodOfPayment.values()) {
            map.put(methodEnum.methodOfPayment, methodEnum);
        }
    }

    MethodOfPayment(int method) {
        methodOfPayment = method;
    }

    public static MethodOfPayment valueOf(int method) {
        return map.get(method);
    }
}


