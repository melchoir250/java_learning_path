package if_else_task;

public class AgeDiscountChecker {
    public static void checkDiscount(int age) {
        if (0 < age && age < 18) {
            System.out.println("Ваша скидка составляет 25%");
        } else if (age >= 65) {
            System.out.println("Ваша скидка составляет 30%");
        } else if (age >= 18) {
            System.out.println("У вас нет скидки на сегодняшний день.");
        } else {
            System.out.println("Ваш возраст не может быть отрицательным.");
        }
    }

    public static void main(String[] args) {
        checkDiscount(12);
        checkDiscount(22);
        checkDiscount(72);
        checkDiscount(-2);
    }
}
