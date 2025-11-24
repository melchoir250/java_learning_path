package do_while_task;
import java.util.Scanner;

public class ExitCommandWaiter {
    public static void Exitcommand() {
        Scanner scanner = new Scanner(System.in);
        String exit;
        do {
            System.out.print("Введи команду: ");
            exit = scanner.nextLine();
        } while(!exit.equals("exit"));
        System.out.println("Команда введена верно.");
    }
    public static void main(String[] args) {
        Exitcommand();
    }
}
