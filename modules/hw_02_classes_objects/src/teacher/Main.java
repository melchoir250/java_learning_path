package teacher;

public class Main {
    public static void main(String[] args) {
        Teacher maria_p = new Teacher("Мария Петровна", "Физика");
        maria_p.printInfo();
        maria_p.setName("Оксана Валентиновна");
        maria_p.setSubject("Математика");
        maria_p.printInfo();

        Teacher ksenia_v = new Teacher("Ксения Вадимовна", "Русские");
        ksenia_v.printInfo();
        ksenia_v.setName("Вероника Павловна");
        ksenia_v.setSubject("Химия");
        ksenia_v.printInfo();
    }
}
