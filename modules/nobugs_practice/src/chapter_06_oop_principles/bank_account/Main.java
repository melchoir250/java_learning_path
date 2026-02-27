package chapter_06_oop_principles.bank_account;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        System.out.println(account.getBalance());
        account.deposit(1000);
        System.out.println(account.getBalance());
        account.withdraw(1000);
        System.out.println(account.getBalance());
    }
}
