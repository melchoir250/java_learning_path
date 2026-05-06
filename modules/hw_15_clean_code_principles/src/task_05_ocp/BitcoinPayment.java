package task_05_ocp;

public class BitcoinPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата Bitcoin на сумму " + amount);
    }
}