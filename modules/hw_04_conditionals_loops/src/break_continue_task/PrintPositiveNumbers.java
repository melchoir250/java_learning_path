package break_continue_task;
import java.util.Scanner;

public class PrintPositiveNumbers {
    public static void PositiveNumber() {
        Scanner scanner = new Scanner(System.in);
        int num;

        while (true) {
            System.out.print("Введите число для подсчета: ");
            num = scanner.nextInt();
            if (num < 0) {
                continue;
            }
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        PositiveNumber();
    }
}
