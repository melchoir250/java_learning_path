package do_while_task;
import java.util.Scanner;

public class PasswordChecker {
    public static void PassCheck() {
        Scanner scanner = new Scanner(System.in);

        String password;
        do {
            System.out.print("Введите пароль: ");
            password = scanner.nextLine();
        } while (!password.equals("333"));
        System.out.println("Пароль введен верно.");
    }
    public static void main(String[] args) {
        PassCheck();
    }
}
