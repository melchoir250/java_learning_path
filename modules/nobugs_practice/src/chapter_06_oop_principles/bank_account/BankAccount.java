package chapter_06_oop_principles.bank_account;

public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Внесенная сумма не может быть не положительной");
        }
    }

    public void withdraw(double amount) {
        if (amount >= 0) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Вы не можете снять больше той суммы, которая у вас на счету ");
            }
        } else {
            System.out.println("Снимаемая сумма не может быть не положительной");
        }
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}