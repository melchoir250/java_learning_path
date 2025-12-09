package chapter_04_conditions_loops;

// 5. Оценка по баллам
//На вход подаётся число от 0 до 100. Выведи оценку по шкале:
//90–100 — "Отлично",
//75–89 — "Хорошо",
//50–74 — "Удовлетворительно",
//меньше 50 — "Неудовлетворительно".

public class GradeEvaluator {
    public static String Grade(int num) {
        if (100 >= num && num >= 90) {
            return "Отлично";
        } else if (89 >= num && num >= 75) {
            return "Хорошо";
        } else if (74 >= num && num >= 50) {
            return "Удовлетворительно";
        } else if (50 >= num && num >= 0) {
            return "Неудовлетворительно";
        } return "Балл не входит в наш диапазон";
    }
    public static void main(String[] args) {
        System.out.println(Grade(101));
        System.out.println(Grade(99));
        System.out.println(Grade(89));
        System.out.println(Grade(55));
        System.out.println(Grade(10));
        System.out.println(Grade(-20));
    }
}
