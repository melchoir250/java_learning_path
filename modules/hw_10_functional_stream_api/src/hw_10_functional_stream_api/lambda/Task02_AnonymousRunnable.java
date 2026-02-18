package hw_10_functional_stream_api.lambda;


public class Task02_AnonymousRunnable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class!");
            }
        };
        runnable.run();
    }
}
