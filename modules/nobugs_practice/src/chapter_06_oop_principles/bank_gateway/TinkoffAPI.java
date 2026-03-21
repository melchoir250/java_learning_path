package chapter_06_oop_principles.bank_gateway;

public class TinkoffAPI implements BankGateway {
    private final int bankComisionPercent = 2;

    @Override
    public void transfer(double amount) {
        if (amount >= 1000) {
            System.out.println("Списано " + amount + " , комиссия банка составила: 0");
        } else {
            amount *= 1 + (bankComisionPercent / 100.0);
            System.out.println("Списано " + amount + " , комиссия банка составила: " + bankComisionPercent + "%");
        }
    }
}