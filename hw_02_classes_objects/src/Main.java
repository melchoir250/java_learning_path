public class Main {
    public static void main(String[] args) {
        Student petya = new Student(18, "Петя");
        petya.print();

        Student Kolya = new Student(22, "Коля");
        Kolya.print();

        petya.setName("Anton");
        petya.print();

        Kolya.setAge(55);
        Kolya.print();
    }
}

