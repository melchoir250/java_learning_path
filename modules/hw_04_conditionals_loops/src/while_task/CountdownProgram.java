package while_task;

public class CountdownProgram {
    public static void CountDown(int num) {
        if (num < 0) {
            System.out.println("Число должно быть положительным");
        }
        while (num >= 0) {
            System.out.println(num);
            num--;
        }
    }

    public static void main(String[] args) {
        CountDown(10);
    }
}
