package while_task;

public class CountdownProgram {
    public static void CountDown(int num) {
        if (num < 0) {
            System.out.println("Число должно быть положительным");
        }
        int i = 1;
        while (i <= num) {
            System.out.println(num);
            num -= i;
        }
    }

    public static void main(String[] args) {
        CountDown(10);
    }
}
