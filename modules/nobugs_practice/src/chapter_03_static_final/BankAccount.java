package chapter_03_static_final;

// Защищённый банковский счёт
//Разработай класс BankAccount, который хранит значение баланса.
//Должны быть методы deposit() и withdraw(), а также метод для получения
//текущего баланса.
//Баланс должен быть недоступен извне для прямого изменения.

public class BankAccount {
    private int balance;

    public BankAccount(int someBalance) {
        this.balance = someBalance;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int deposit_balance) {
        balance = balance + deposit_balance;
        return balance;
    }

    public int withdraw(int withdraw_balance) {
        balance = balance - withdraw_balance;
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account_vasya = new BankAccount(20000);
        System.out.println(account_vasya.getBalance());
        System.out.println(account_vasya.deposit(100000));
        System.out.println(account_vasya.withdraw(30000));
    }
}
