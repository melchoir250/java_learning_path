package chapter_02_classes_objects;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("2012", "Уилл Смитт");
        book1.printInfo();

        Movie mov1 = new Movie("Артур и Минипуты", 2010);
        mov1.describe();

        Phone nokia = new Phone("Nokia", 90);
        nokia.call("88002225525");

        User user_petr = new User("Петр", 12);
        user_petr.introduce();

        Rectangle rect1 = new Rectangle(12, 4);
        System.out.println("Площадь: " + rect1.getArea());
        System.out.println("Квадрат? " + rect1.isSquare());
    }
}
