package break_continue_task;
import java.util.Scanner;

public class StopCommandReader {
    public static void StopCommand() {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.print("Введите текст: ");
            command = scanner.next();

        } while (!command.equals("stop"));
    }

    public static void main(String[] args) {
        StopCommand();
    }
}
