package if_else_task;

public class MaxOfTwo {
    public static void main(String[] args) {
        System.out.println(Scanner(12, 7));
        System.out.println(Scanner(-2, 4));
    }

    public static int Scanner(int a, int b) {
        int maxAB = a;
        if (a < b) {
            maxAB = b;
        }
        return maxAB;
    }
}
