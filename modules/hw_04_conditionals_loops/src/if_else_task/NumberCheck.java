package if_else_task;

public class NumberCheck {
    public static void main(String[] args) {
        System.out.println(Scanner(2));
        System.out.println(Scanner(-2));
        System.out.println(Scanner(0));
    }

    public static String Scanner(int num) {
        String numDescription = "";
        if (num > 0) {
            numDescription = "Число положительное";
        } else if (num < 0) {
            numDescription = "Число отрицательное";
        } else {
            numDescription = "Число равно нулю";
        }
        return numDescription;
    }
}
