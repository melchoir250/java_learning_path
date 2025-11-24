package for_task;

public class PrimeNumberChecker {
    public static boolean NumCheck(int num) {
        boolean isPrime = true;
        for (int i = 2; i <= num - 1; i++) {
            if (num % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        System.out.println(NumCheck(5));
    }
}
