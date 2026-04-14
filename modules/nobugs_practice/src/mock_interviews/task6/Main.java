package mock_interviews.task6;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CryptoPayment cryptoPayment1 = new CryptoPayment("Ivan", 10000.0, 2000);
        CryptoPayment cryptoPayment2 = new CryptoPayment("Petr", 10000.0, 20000);

        CreditCardPayment creditCardPayment1 = new CreditCardPayment("Max", 1000, 200);
        CreditCardPayment creditCardPayment2 = new CreditCardPayment("Sanya", 2000, 5000);

        PayPalPayment payPalPayment1 = new PayPalPayment("Slava", 1000, 200);
        PayPalPayment payPalPayment2 = new PayPalPayment("Egor", 1000, 3300);

        PaymentService paymentService1 = new PaymentService(List.of(cryptoPayment1, creditCardPayment1, payPalPayment1));
        paymentService1.paymentsList();

        PaymentService paymentService2 = new PaymentService(List.of(cryptoPayment2, creditCardPayment2, payPalPayment2));
        paymentService2.paymentsList();
    }
}