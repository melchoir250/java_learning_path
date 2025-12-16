package chapter_04_conditions_loops;

// 31. Определение сезона по номеру месяца
// Вводится число от 1 до 12.
// Определи, к какому времени года относится этот месяц.

import java.util.Scanner;

public class SeasonByMonthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();

        System.out.println(getSeasonByMonth(month));
    }

    public static String getSeasonByMonth(int month) {
        switch (month) {
            case 12, 1, 2:
                return "Зима";
            case 3, 4, 5:
                return "Весна";
            case 6, 7, 8:
                return "Лето";
            case 9, 10, 11:
                return "Осень";
            default:
                return "Некорректный номер месяца";
        }
    }
}