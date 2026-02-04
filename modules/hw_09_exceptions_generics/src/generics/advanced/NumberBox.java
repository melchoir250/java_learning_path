package generics.advanced;


import java.util.List;
import java.util.Objects;

public class NumberBox<T extends Number> {
    private List<T> num;

    public NumberBox(List<T> num) {
        this.num = num;
    }

    public double getSum() {
        double sum = 0.0;
        for (T number : num) {
            sum += number.doubleValue();
        }

        return sum;
    }

    public static double sum(List<? extends Number> list)  {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void addNubmer(List<? super Integer> list) {
        for (Object num : list) {
            Integer i = (Integer) num;
            System.out.println(i);
        }
    }
}
