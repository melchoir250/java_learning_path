package mock_interviews.task6;

public abstract class PaymentMethodAbstract implements PaymentMethod{
    protected final String nameUserWallet;
    protected double balanceWallet;
    protected double amountWallet;

    public PaymentMethodAbstract(String nameUserWallet, double balanceWallet, double amountWallet) {
        this.nameUserWallet = nameUserWallet;
        this.balanceWallet = balanceWallet;
        this.amountWallet = amountWallet;
    }

    public String getNameUserWallet() {
        return nameUserWallet;
    }

    public double getBalanceWallet() {
        return balanceWallet;
    }

    public double getAmountWallet() {
        return amountWallet;
    }

    public void setBalanceWallet(double balanceWallet) {
        this.balanceWallet = balanceWallet;
    }

    public void setAmountWallet(double amountWallet) {
        this.amountWallet = amountWallet;
    }
}
