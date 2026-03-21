package chapter_06_oop_principles.payment_methods;


public class GooglePay implements PaymentMethod {
    private final String accountGooglePay;
    private double balanceGooglePay;

    public GooglePay(String accountGooglePay, double balanceGooglePay) {
        this.accountGooglePay = accountGooglePay;
        this.balanceGooglePay = balanceGooglePay;
    }

    public String getAccountGooglePay() {
        return accountGooglePay;
    }

    public double getBalanceGooglePay() {
        return balanceGooglePay;
    }

    public void setBalanceGooglePay(double balanceGooglePay) {
        this.balanceGooglePay = balanceGooglePay;
    }

    @Override
    public void pay(double amount) {
        if (balanceGooglePay >= amount) {
            this.balanceGooglePay -= amount;
            System.out.println("Оплата: " + amount + " прошла успешно, через GooglePay: " + accountGooglePay);
        } else {
            System.out.println("Недостаточно денег на балансе GooglePay: " + accountGooglePay);
        }
    }
}