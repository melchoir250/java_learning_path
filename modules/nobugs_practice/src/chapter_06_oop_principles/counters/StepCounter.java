package chapter_06_oop_principles.counters;


public class StepCounter extends Counter {
    private int step;

    public StepCounter(int value, int step) {
        super(value);
        this.step = step;
    }

    @Override
    public void increment() {
        value += step;
    }

}