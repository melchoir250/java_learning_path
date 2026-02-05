package chapter_04_conditions_loops;

// 68. Математический тренажёр
// Генерируй случайные выражения вида a + b.
// Пользователь должен ввести правильный ответ.
// После 5 правильных решений — завершить.

import java.util.Random;
import java.util.Scanner;

public class MathTrainer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int correctCount = 0;

        while (correctCount < 5) {
            int a = random.nextInt(10);
            int b = random.nextInt(10);

            System.out.print(a + " + " + b + " = ");
            int answer = scanner.nextInt();

            if (answer == a + b) {
                System.out.println("Верно!");
                correctCount++;
            } else {
                System.out.println("Неверно. Правильный ответ: " + (a + b));
            }
        }

        System.out.println("Тренировка завершена! 5 правильных ответов 🎉");
    }
}