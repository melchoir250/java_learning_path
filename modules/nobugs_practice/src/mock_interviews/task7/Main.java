package mock_interviews.task7;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("Boing", "рулит по РД");
        Airplane airplane2 = new Airplane("Airbus", "летит на привод");

        Bicycle bicycle1 = new Bicycle("BMX", "едет по лесу");
        Bicycle bicycle2 = new Bicycle("Stels", "везет ребенка по городу");

        Car car1 = new Car("Toyota", "едет по пустыне");
        Car car2 = new Car("Kia", "везет пассажира в аэропорт");

        TransportService transportService = new TransportService(List.of(
                airplane1,
                airplane2,
                bicycle1,
                bicycle2,
                car1,
                car2
        ));
        transportService.addTransport();
    }
}