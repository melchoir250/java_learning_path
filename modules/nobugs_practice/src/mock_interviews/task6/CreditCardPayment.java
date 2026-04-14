package mock_interviews.task6;

public class CreditCardPayment extends PaymentMethodAbstract {
    public CreditCardPayment(String nameUserWallet, double balanceWallet, double amountWallet) {
        super(nameUserWallet, balanceWallet, amountWallet);
    }

    @Override
    public double amount() {
        if (balanceWallet - amountWallet < 0) {
            throw new IllegalArgumentException("Не может быть отрицательный баланс");
        }
        return balanceWallet - amountWallet;
    }

    @Override
    public String nameWallet() {
        return "Банковская карта " + nameUserWallet;
    }
}