package chapter_03_static_final;
import java.util.Scanner;

// 2. Счётчик пользователей
// Создай класс User, где каждый пользователь имеет имя.
// Класс должен вести подсчёт общего количества созданных пользователей. Этот
// счётчик должен автоматически увеличиваться при создании каждого нового объекта.
// Также добавь возможность вывести общее количество пользователей.
// Пояснение: реши, как отслеживать общее количество объектов независимо от экземпляров.

public class UserCounter {
    static int count;

    public static void User() {
        Scanner scanner = new Scanner(System.in);
        String name;
        do {
            System.out.print("Введите пользователя: ");
            name = scanner.nextLine();
            count ++;
        } while (!name.equals("stop"));
        System.out.print("Количество пользователей: " + count);
    }

    public static void main(String[] args) {
        User();
    }



}
