package hw_11_multithreading.task_03_volatile;


public class Task03_VolatileStop {

    private static volatile boolean stop = false;

    public static void main(String[] args) {
        Runnable task = () -> {
            int count = 0;

            while (!stop) {
                count++;
            }

            System.out.println("Поток остановлен. Счетчик = " + count);
        };

        Thread worker = new Thread(task);
        worker.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        stop = true;
        System.out.println("Флаг установлен True");
    }
}
