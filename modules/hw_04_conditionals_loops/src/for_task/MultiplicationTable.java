package for_task;

public class MultiplicationTable {
    public static void MultiplNum(int num) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + num * i);
        }
    }

    public static void main(String[] args) {
        MultiplNum(3);
    }
}
