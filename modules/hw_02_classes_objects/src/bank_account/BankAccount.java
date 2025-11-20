package bank_account;

public class BankAccount {
    String owner;
    int balance;

    BankAccount(int someBalance, String someOwner) {
        this.balance = someBalance;
        this.owner = someOwner;
    }

    String getOwner() {

        return this.owner;
    }

    void setOwner(String newOwner) {

        this.owner = newOwner;
    }

    void deposit(int amount) {

        this.balance += amount;
    }

    void withdraw(int amount) {

        this.balance -= amount;
    }

    void printBalance() {

        System.out.println("Баланс счета: " + this.balance + ", Владелец счета: " + getOwner());
    }
}
