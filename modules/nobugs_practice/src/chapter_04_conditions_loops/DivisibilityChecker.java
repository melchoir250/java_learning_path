package chapter_04_conditions_loops;

// 4. Проверка кратности
//Определи, делится ли введённое число на 3 без остатка.

public class DivisibilityChecker {
    public static String DivisibleCheck(int num) {
        String div_check = "Число не делится";
        if (num % 3 == 0) {
            div_check = "Число делится";
        }
        return div_check;
    }
    public static void main(String[] args) {
        System.out.println(DivisibleCheck(13));
        System.out.println(DivisibleCheck(15));
    }
}
