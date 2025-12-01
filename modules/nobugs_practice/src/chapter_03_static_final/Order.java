package chapter_03_static_final;

// 11. Генерация уникального ID
//Создай класс Order, каждый объект которого при создании автоматически получает
//уникальный числовой идентификатор (например, 1, 2, 3, ...).
//ID должен быть доступен только для чтения и не изменяться после присвоения.
//Класс должен хранить и увеличивать счётчик самостоятельно.
//Пояснение: реализуй механизм автогенерации значения, доступного каждому объекту,
//но основанного на общей для класса информации.

public class Order {
    static int count = 1;
    private final int id;
    String order;

    Order(String someOrder) {
        this.order = someOrder;
        this.id = count ++;
    }

    public String getOrder() {
        return this.order;
    }

    public void print() {
        System.out.println("Order: " + getOrder() + " " + this.id);
    }

    public static void main(String[] args) {
        Order tv = new Order("TV");
        tv.print();
        Order phone = new Order("Samsung");
        Order laptop = new Order("Laptop");

        phone.print();
        laptop.print();
        tv.print();
    }

}
