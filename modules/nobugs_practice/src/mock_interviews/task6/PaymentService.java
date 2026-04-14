package mock_interviews.task6;

import java.util.List;

public class PaymentService {
    public List<PaymentMethod> paymentMethods;

    public PaymentService(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void paymentsList() {
        for (PaymentMethod item : paymentMethods) {
            System.out.println(item.nameWallet() + " проводит оплату на сумму " + item.amount());
        }
    }
}