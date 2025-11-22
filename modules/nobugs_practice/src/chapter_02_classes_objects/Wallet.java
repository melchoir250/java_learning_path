package chapter_02_classes_objects;

public class Wallet {
    double balance;

    Wallet(double someBalance) {
        this.balance = someBalance;
    }

    double pay(double amount) {
        if (this.balance < amount) {
            return this.balance;
        }
        return this.balance -= amount;
    }

    double addMoney(double amount) {
        return this.balance += amount;
    }

    void print() {
        System.out.println(balance);
    }

    public static void main(String[] args) {
        Wallet ton = new Wallet(1000);
        ton.print();
        ton.pay(10);
        ton.print();
        ton.addMoney(200);
        ton.print();
    }
}
