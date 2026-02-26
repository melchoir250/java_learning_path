package hw_11_multithreading.task_01_single_thread;

import javax.imageio.plugins.tiff.TIFFImageReadParam;

public class Task01_SingleThread {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Привет из потока!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
