package for_task;

public class SumFromOneToN {
    public static int SumNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(SumNum(5));
    }
}
