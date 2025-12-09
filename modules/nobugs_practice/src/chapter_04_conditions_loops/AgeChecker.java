package chapter_04_conditions_loops;

//2. Проверка возраста на совершеннолетие
//Вводится возраст. Выведи, совершеннолетний ли пользователь или нет.

public class AgeChecker {
    public static String AgeCheck(int num) {
        String check_age = "Несовершеннолетний";
        if (num >= 18) {
            check_age = "Совершеннолетний";
        }
        return check_age;
    }

    public static void main(String[] args) {
        System.out.println(AgeCheck(17));
        System.out.println(AgeCheck(18));
        System.out.println(AgeCheck(19));
    }
}
