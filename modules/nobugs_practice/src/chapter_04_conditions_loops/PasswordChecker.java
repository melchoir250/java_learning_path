package chapter_04_conditions_loops;

// 12. Пароль с попытками
//Реализуй проверку пароля с максимум тремя попытками. После трёх неудач
//выводится сообщение "Доступ запрещён"

import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        System.out.println(password());
    }
    public static String password() {
        int PASSWORD = 23674;
        Scanner scanner = new Scanner(System.in);
        int num;
        int count = 0;
        while (count < 3) {
            System.out.print("Введите пароль(цифрами): ");
            num = scanner.nextInt();
            if (num == PASSWORD) {
                return "Пароль верный";
            }
            count ++;
        }
        return "Доступ запрещён";
    }
}
