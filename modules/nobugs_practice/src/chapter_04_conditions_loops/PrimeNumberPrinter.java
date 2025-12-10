package chapter_04_conditions_loops;

//22. Простые числа от 2 до 100
//Выведи все простые числа от 2 до 100 включительно.

public class PrimeNumberPrinter {
    public static void main(String[] args) {
        primeNumber();
    }

    public static void primeNumber() {

        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}
