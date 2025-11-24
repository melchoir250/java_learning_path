package if_else_task;

public class TestScoreEvaluator {
    public static void Scanner(int scope) {
        if (scope >= 90 && scope <= 100) {
            System.out.println("Отлично");
        } else if (scope < 90 && scope >= 75) {
            System.out.println("Хорошо");
        } else if (scope >= 60 && scope < 75) {
            System.out.println("Удовлетворительно");
        } else if (scope < 60 && scope > 0) {
            System.out.println("Неудовлетворитльно");
        } else {
            System.out.println("Такой оценки не существует");
        }
    }

    public static void main(String[] args) {
        Scanner(101);
        Scanner(100);
        Scanner(80);
        Scanner(70);
        Scanner(50);
        Scanner(0);
        Scanner(-10);
    }
}
