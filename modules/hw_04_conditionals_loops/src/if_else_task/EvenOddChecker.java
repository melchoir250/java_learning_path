package if_else_task;

public class EvenOddChecker {
    public static String Scanner(int num) {
        String oddCheck = "Нечетное";
        if (num % 2 == 0) {
            oddCheck = "Четное";
        }
        return oddCheck;
    }

    public static void main(String[] args) {
        System.out.println(Scanner(3));
        System.out.println(Scanner(10));
    }
}
