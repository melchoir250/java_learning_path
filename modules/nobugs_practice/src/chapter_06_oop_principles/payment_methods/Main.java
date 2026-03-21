package chapter_06_oop_principles.payment_methods;


import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PaymentMethod> payments = List.of(

                new CreditCard(
                        "Ivan",
                        "Ivanov",
                        1234567812345678L,
                        YearMonth.of(2026, 3),
                        123,
                        1500.50
                ),

                new PayPal(
                        "ivan.paypal@gmail.com",
                        800.75
                ),

                new GooglePay(
                        "ivan.gpay@gmail.com",
                        1200.00
                ),

                new CryptoWallet(
                        9876543210123456L,
                        2.5
                ),

                new CreditCard(
                        "Petr",
                        "Petrov",
                        1111222233334444L,
                        YearMonth.of(2027, 12),
                        456,
                        3200.00
                ),

                new PayPal(
                        "petr.paypal@gmail.com",
                        150.00
                ),

                new GooglePay(
                        "petr.gpay@gmail.com",
                        980.40
                ),

                new CryptoWallet(
                        5555444433332222L,
                        0.75
                )
        );

        List<PaymentMethod> paymentMethods = new ArrayList<>(payments);

        for (PaymentMethod payFunctionalAccounts : paymentMethods) {
            payFunctionalAccounts.pay(500);
        }
    }
}