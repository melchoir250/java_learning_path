package chapter_06_oop_principles.homework_tracking;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr.Smith");
        JavaTask javaTask1 = new JavaTask("22", "Add", "Nikolay");

        System.out.println(javaTask1.submit());
        teacher.evaluate(javaTask1, 4);
        System.out.println(javaTask1.getScore());
        javaTask1.grade(3);
        System.out.println(javaTask1.getScore());

        MathTask mathTask1 = new MathTask("good", "petr@gmail.com", "Petr", "Add", "33");
        teacher.evaluate(mathTask1, 4);
        System.out.println(mathTask1.submit());
        teacher.evaluate(javaTask1, 2);
        System.out.println(javaTask1.getScore());
    }
}