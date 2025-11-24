package do_while_task;
import java.util.Scanner;

public class PositiveNumberInput {
    public static void PositiveNumber() {
        Scanner scanner = new Scanner(System.in);

        int number;
        int sum = -10;

        do {
            System.out.print("Введите число: ");
            number = scanner.nextInt();
            if (number > 0) sum += number;
        } while (sum <= 0);

        System.out.println("Вывод числа: " + sum);
    }

    public static void main(String[] args) {
        PositiveNumber();
    }
}
