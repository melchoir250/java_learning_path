package while_task;

public class EvenNumbersWhile {
    public static void EvenNumber(int num) {
        int i = 1;
        while (i <= num) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        EvenNumber(10);
    }
}

