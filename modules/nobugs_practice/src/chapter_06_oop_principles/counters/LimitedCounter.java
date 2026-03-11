package chapter_06_oop_principles.counters;

public class LimitedCounter extends Counter {
    private int maxValue;

    public LimitedCounter(int value, int maxValue) {
        super(value);
        this.maxValue = maxValue;
    }

    @Override
    public void increment() {
        if (value >= maxValue) {
            value = maxValue;
        } else {
            value++;
        }
    }
}