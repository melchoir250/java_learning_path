package chapter_04_conditions_loops;

//27. Уровень зарплаты по опыту
//Вводится количество лет опыта.
//До 1 года — "Junior",
//1–3 — "Middle",
//4–6 — "Senior",
//7 и более — "Lead".

import java.util.Scanner;

public class ExperienceLevelChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество лет опыта: ");
        int expLevel = scanner.nextInt();

        System.out.println(getExperienceLevel(expLevel));
    }

    public static String getExperienceLevel(int expLevel) {
        if (expLevel < 1) {
            return "Grade: Junior";
        } else if (expLevel <= 3) {
            return "Grade: Middle";
        } else if (expLevel <= 6) {
            return "Grade: Senior";
        } else {
            return "Grade: Lead";
        }
    }
}
