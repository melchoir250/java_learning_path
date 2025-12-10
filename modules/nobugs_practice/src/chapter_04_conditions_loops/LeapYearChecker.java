package chapter_04_conditions_loops;

// 11. Проверка високосного года
//На вход подаётся год. Определи, является ли он високосным.

public class LeapYearChecker {
    public static String leapYear(int year) {
        String year_leap = "Невисокосный год";
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            year_leap = "Високосный год";
        }
        return year_leap;
    }

    public static void main(String[] args) {
        System.out.println(leapYear(1900));
        System.out.println(leapYear(1966));
        System.out.println(leapYear(1999));
        System.out.println(leapYear(1996));
        System.out.println(leapYear(2000));
    }
}
