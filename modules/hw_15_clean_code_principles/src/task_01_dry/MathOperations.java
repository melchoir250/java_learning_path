package task_01_dry;

public class MathOperations {

    public int add(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
}