package while_task;

public class FactorialCalculator {
    public static int Factorial(int num) {
        int i = 1;
        int sum = 1;
        while (i <= num) {
            sum *= i;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Factorial(4));
    }
}
