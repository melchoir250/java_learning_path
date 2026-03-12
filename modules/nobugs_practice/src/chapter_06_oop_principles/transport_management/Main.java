package chapter_06_oop_principles.transport_management;

public class Main {
    public static void main(String[] args) {
        Transport bicycle = new Bicycle();
        Transport car = new Car();
        Transport train = new Train();

        System.out.println("=== Движение транспорта ===\n");

        bicycle.move(3);
        car.move(2);
        train.move(1);

        System.out.println("\n=== Итоговый пробег ===");
        System.out.printf("%s проехал: %.1f км\n", bicycle.getName(), bicycle.getDistanceTraveled());
        System.out.printf("%s проехал: %.1f км\n", car.getName(), car.getDistanceTraveled());
        System.out.printf("%s проехал: %.1f км\n", train.getName(), train.getDistanceTraveled());

        System.out.println("\n=== Соревнование: 4 часа в пути ===");

        Transport[] transports = {new Bicycle(), new Car(), new Train()};

        for (Transport t : transports) {
            t.move(4);
        }

        System.out.println("\n=== Результаты соревнования ===");
        Transport winner = transports[0];
        for (Transport t : transports) {
            System.out.printf("%s: %.1f км\n", t.getName(), t.getDistanceTraveled());
            if (t.getDistanceTraveled() > winner.getDistanceTraveled()) {
                winner = t;
            }
        }
        System.out.printf("\nПобедитель: %s с результатом %.1f км!\n",
                winner.getName(), winner.getDistanceTraveled());
    }
}