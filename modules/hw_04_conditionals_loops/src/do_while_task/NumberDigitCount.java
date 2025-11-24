package do_while_task;
import java.util.Scanner;

public class NumberDigitCount {
    public static void NumberDo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для подсчета: ");
        int num = scanner.nextInt();
        int count = 0;
        if (num == 0) {
            count = 1;
        } else {
            do {
                num = num / 10;
                count ++;
            } while (num > 0);
        }
        System.out.println("Кол-во цифр: " + count);
    }
    public static void main(String[] args) {
        NumberDo();
    }
}
