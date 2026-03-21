package chapter_06_oop_principles.payment_methods;

import java.time.YearMonth;

public class CreditCard implements PaymentMethod {
    private final String firstName;
    private final String lastName;
    private final long cardNumber;
    private final YearMonth cardDate;
    private final int cardCVC;
    private double cardBalance;

    public CreditCard(String firstName, String lastName, long cardNumber, YearMonth cardDate, int cardCVC, double cardBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
        this.cardCVC = cardCVC;
        this.cardBalance = cardBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public YearMonth getCardDate() {
        return cardDate;
    }

    public int getCardCVC() {
        return cardCVC;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    @Override
    public void pay(double amount) {
        if (cardBalance >= amount) {
            this.cardBalance -= amount;
            System.out.println("Оплата: " + amount + " прошла успешно, деньги списаны с карты: " + cardNumber);
        } else {
            System.out.println("Недостаточно денег на " + cardNumber);
        }
    }
}