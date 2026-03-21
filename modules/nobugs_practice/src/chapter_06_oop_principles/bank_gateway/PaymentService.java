package chapter_06_oop_principles.bank_gateway;

public class PaymentService {
    private BankGateway bank;

    public PaymentService(BankGateway bank) {
        this.bank = bank;
    }

    public BankGateway getBank() {
        return bank;
    }

    public void setBank(BankGateway bank) {
        this.bank = bank;
    }

    public void executePayment(double amount) {
        System.out.println("Сервис подготовки платежа: инициируем перевод...");
        bank.transfer(amount);
    }
}