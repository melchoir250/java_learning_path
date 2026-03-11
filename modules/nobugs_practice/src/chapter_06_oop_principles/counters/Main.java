package chapter_06_oop_principles.counters;

public class Main {
    public static void main(String[] args) {
        Counter regular = new Counter(0);
        StepCounter stepCounter = new StepCounter(0, 5);
        LimitedCounter limitedCounter = new LimitedCounter(7, 10);

        regular.increment(); // стало 1
        stepCounter.increment(); // стало 5
        limitedCounter.increment(); // стало 8
        limitedCounter.increment(); // стало 9
        limitedCounter.increment(); // стало 10
        limitedCounter.increment(); // осталось 10 (не увеличивается)

        System.out.println("Обычный: " + regular.getValue());       // 1
        System.out.println("Шаговый: " + stepCounter.getValue());   // 5
        System.out.println("Лимитный: " + limitedCounter.getValue()); // 10
    }
}