package chapter_02_classes_objects;

public class Email {
    String sender;
    String receiver;
    String subject;

    Email(String someSender, String someReceiver, String someSubject) {
        this.sender = someSender;
        this.receiver = someReceiver;
        this.subject = someSubject;
    }

    void send() {
        System.out.println("Письмо от " + this.sender + " к " + this.receiver +
                ", с темой " + this.subject + " отправлено.");
    }

    public static void main(String[] args) {
        Email vladimir = new Email("Владимира", "Марии", "Документы");
        vladimir.send();
    }
}
