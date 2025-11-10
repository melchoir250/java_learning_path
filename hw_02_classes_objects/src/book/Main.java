package book;

public class Main {
    public static void main(String[] args) {
        Book mark_tven = new Book("Том Сойер", "Марк Твен");
        mark_tven.printInfo();
        mark_tven.setAuthor("Лермонтов");
        mark_tven.setTitle("Демон");
        mark_tven.printInfo();

        Book pushkin = new Book("Капитанская дочка", "Пушкин");
        pushkin.printInfo();
        pushkin.setAuthor("Толстой");
        pushkin.setTitle("Война и Мир");
        pushkin.printInfo();
    }
}
