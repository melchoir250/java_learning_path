package task_05_furniture_abstract_factory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Клиент 1 покупает современный интерьер");
        FurnitureFactory factory1 = new ModernFurnitureFactory();

        Chair chair1 = factory1.createChair();
        Table table1 = factory1.createTable();

        chair1.sitOn();
        table1.use();

        System.out.println("Клиент 2 покупает классический интерьер");
        FurnitureFactory factory2 = new ClassicFurnitureFactory();

        Chair chair2 = factory2.createChair();
        Table table2 = factory2.createTable();

        chair2.sitOn();
        table2.use();
    }
}