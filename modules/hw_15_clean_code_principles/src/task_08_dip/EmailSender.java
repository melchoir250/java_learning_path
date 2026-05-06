package task_08_dip;

public class EmailSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("Отправка email: " + message);
    }
}