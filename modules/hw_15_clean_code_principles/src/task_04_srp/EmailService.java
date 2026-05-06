package task_04_srp;

public class EmailService {
    public void sendConfirmation(String email, String message) {
        System.out.println("Отправляем письмо на " + email + ": " + message);
    }
}