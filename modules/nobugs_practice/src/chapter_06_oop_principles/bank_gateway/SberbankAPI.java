package chapter_06_oop_principles.bank_gateway;

public class SberbankAPI implements BankGateway {
    private final double bankComision = 30.0;

    @Override
    public void transfer(double amount) {
        amount += bankComision;
        System.out.println("Списано " + amount + " , комиссия банка составила: " + bankComision);
    }
}