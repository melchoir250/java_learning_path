package chapter_06_oop_principles.payment_methods;


public class PayPal implements PaymentMethod {
    private final String emailAccountPayPal;
    private double balancePayPal;

    public PayPal(String emailAccountPayPal, double balancePayPal) {
        this.emailAccountPayPal = emailAccountPayPal;
        this.balancePayPal = balancePayPal;
    }

    public String getEmailAccountPayPal() {
        return emailAccountPayPal;
    }

    public double getBalancePayPal() {
        return balancePayPal;
    }

    public void setBalancePayPal(double balancePayPal) {
        this.balancePayPal = balancePayPal;
    }

    @Override
    public void pay(double amount) {
        if (balancePayPal >= amount) {
            this.balancePayPal -= amount;
            System.out.println("Оплата: " + amount + " прошла успешно, через PayPal: " + emailAccountPayPal);
        } else {
            System.out.println("Недостаточно денег на балансе PayPal: " + emailAccountPayPal);
        }
    }
}