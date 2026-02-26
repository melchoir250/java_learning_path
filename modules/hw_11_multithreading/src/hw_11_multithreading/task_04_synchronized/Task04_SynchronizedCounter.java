package hw_11_multithreading.task_04_synchronized;


public class Task04_SynchronizedCounter {
    static class Counter {
        int count = 0;

        public synchronized void increment() {
            count++;
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Итоговый count: " + counter.count);
    }
}
