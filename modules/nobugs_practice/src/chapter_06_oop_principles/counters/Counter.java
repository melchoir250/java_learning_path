package chapter_06_oop_principles.counters;

public class Counter {
    protected int value;

    public Counter(int value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}