package switch_task;

public class DayOfWeekPrinter {
    public static String DayOfWeek(int day) {
        String dayDescription = "";
        switch (day) {
            case 1:
                dayDescription = "Понедельник";
                break;
            case 2:
                dayDescription = "Вторник";
                break;
            case 3:
                dayDescription = "Среда";
                break;
            case 4:
                dayDescription = "Четверг";
                break;
            case 5:
                dayDescription = "Пятница";
                break;
            case 6:
                dayDescription = "Суббота";
                break;
            case 7:
                dayDescription = "Воскресенье";
                break;
            default:
                dayDescription = "Такого дня недели не существует.";
        }
        return dayDescription;
    }

    public static void main(String[] args) {
        System.out.println(DayOfWeek(1));
        System.out.println(DayOfWeek(10));
        System.out.println(DayOfWeek(5));
        System.out.println(DayOfWeek(3));
    }
}
