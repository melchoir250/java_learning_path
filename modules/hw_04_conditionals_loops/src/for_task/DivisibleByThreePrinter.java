package for_task;

public class DivisibleByThreePrinter {
    public static void DivisibleThree() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        DivisibleThree();
    }
}
