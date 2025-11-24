package break_continue_task;
import java.util.Scanner;

public class SumUntilNegative {
    public static void SumNegative() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int number;
        while (true) {
            System.out.print("Введите число для подсчета: ");
            number = scanner.nextInt();
            if (number < 0) {
                break;
            }
            sum = sum + number;
        }
        System.out.print(sum);
    }

    public static void main(String[] args) {
        SumNegative();
    }
}
