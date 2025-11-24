package if_else_task;

public class GradeScaleOutput {
    public static void Scaner(int grade) {
        switch (grade) {
            case 5:
                System.out.println("Отлично");
                break;
            case 4:
                System.out.println("Хорошо");
                break;
            case 3:
                System.out.println("Удовлетворительно");
                break;
            case 2:
                System.out.println("Неудволитворительно");
                break;
            case 1:
                System.out.println("Неудовлетворительно");
                break;
            default:
                System.out.println("Такая оценка невозможна");
        }
    }

    public static void main(String[] args) {
        Scaner(4);
        Scaner(3);
        Scaner(2);
        Scaner(1);
        Scaner(22);
    }
}
