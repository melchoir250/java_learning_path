package bank_account;

public class Main {
    public static void main(String[] args) {
        BankAccount deposit_alex = new BankAccount(100, "Alex");
        deposit_alex.printBalance();
        deposit_alex.withdraw(70);
        deposit_alex.printBalance();
        deposit_alex.setOwner("Александр");
        deposit_alex.deposit(120);
        deposit_alex.printBalance();

        BankAccount deposit_pasha = new BankAccount(200, "Pasha");
        deposit_pasha.printBalance();
        deposit_pasha.deposit(220);
        deposit_pasha.printBalance();
        deposit_pasha.setOwner("Павел");
        deposit_pasha.withdraw(111);
        deposit_pasha.printBalance();
    }
}
