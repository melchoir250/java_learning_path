package chapter_06_oop_principles.transport_schedule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TransportSchedule> addTransportSchedule = List.of(
                new BusSchedule("Московский", "Санкт-Петербург", "Москва", LocalDateTime.of(2026, 3, 22, 17, 43, 12)),
                new TrainSchedule("Сапсан", "Санкт-Петербург", "Москва", LocalDateTime.of(2026, 3, 22, 17, 43, 12), 3),
                new FlightSchedule("Аэрофлот", "Санкт-Петербург", "Москва", LocalDateTime.of(2026, 3, 22, 17, 43, 12), 4, 4353)
        );

        List<TransportSchedule> transportSchedules = new ArrayList<>(addTransportSchedule);
        for (TransportSchedule trasport : transportSchedules) {
            System.out.println(trasport.getNextDeparture());
        }
    }
}
