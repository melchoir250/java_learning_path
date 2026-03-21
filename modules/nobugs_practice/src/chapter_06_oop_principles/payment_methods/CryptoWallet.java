package chapter_06_oop_principles.payment_methods;


public class CryptoWallet implements PaymentMethod {
    private final long addressCryptoWallet;
    private double balanceCryptoWallet;

    public CryptoWallet(long addressCryptoWallet, double balanceCryptoWallet) {
        this.addressCryptoWallet = addressCryptoWallet;
        this.balanceCryptoWallet = balanceCryptoWallet;
    }

    public long getAddressCryptoWallet() {
        return addressCryptoWallet;
    }

    public double getBalanceCryptoWallet() {
        return balanceCryptoWallet;
    }

    public void setBalanceCryptoWallet(double balanceCryptoWallet) {
        this.balanceCryptoWallet = balanceCryptoWallet;
    }

    @Override
    public void pay(double amount) {
        double walletFeeMultiplier = 1.02;
        if (balanceCryptoWallet >= amount * walletFeeMultiplier) {
            this.balanceCryptoWallet -= amount * walletFeeMultiplier;
            System.out.println("Оплата: " + amount + " прошла успешно, через CryptoWallet: " + addressCryptoWallet);
        } else {
            System.out.println("Недостаточно денег на балансе CryptoWallet: " + addressCryptoWallet);
        }
    }
}