package chapter_02_classes_objects;

public class BankAccount {
    static double balance;

    BankAccount(double someBalance) {
        balance = someBalance;
    }

    double deposit(double amount) {
        balance += amount;
        return balance;
    }

    double withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return balance;
        }
        return balance;
    }

    void printBalance() {
        System.out.println("Текущий баланс: " + balance);
    }

    public static void main(String[] args) {
        BankAccount deposit1 = new BankAccount(100);
        deposit1.deposit(39.6);
        deposit1.printBalance();

        BankAccount deposit2 = new BankAccount(100);
        deposit2.withdraw(80.3);
        deposit2.printBalance();
        deposit2.withdraw(20);
        deposit2.printBalance();
    }
}
