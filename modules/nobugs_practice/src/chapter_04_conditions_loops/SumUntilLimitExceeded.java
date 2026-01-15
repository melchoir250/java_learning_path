package chapter_04_conditions_loops;

// 47. Сумма до превышения лимита
// Пользователь вводит числа.
// Заверши ввод, когда сумма всех чисел превысит 100.
// После этого выведи итоговую сумму.

import java.util.Scanner;

public class SumUntilLimitExceeded {
    public static void main(String[] args) {
        sumUntilLimit();
    }

    public static void sumUntilLimit() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (sum <= 100) {
            System.out.print("Введите число: ");
            int num = scanner.nextInt();
            sum += num;
        }
        System.out.println(sum);
    }
}
