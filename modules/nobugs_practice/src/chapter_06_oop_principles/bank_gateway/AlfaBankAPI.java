package chapter_06_oop_principles.bank_gateway;

public class AlfaBankAPI implements BankGateway {
    private final int bankComisionPercent = 5;

    @Override
    public void transfer(double amount) {
        if (amount >= 10000) {
            System.out.println("Списано " + amount + " , комиссия банка составила: 0");
        } else {
            amount *= 1 + (bankComisionPercent / 100.0);
            System.out.println("Списано " + amount + " , комиссия банка составила: " + bankComisionPercent + "%");
        }
    }
}