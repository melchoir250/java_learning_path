package chapter_06_oop_principles.transport_schedule;

import java.time.LocalDateTime;

public class BusSchedule extends TransportSchedule {
    private final LocalDateTime startTime;

    public BusSchedule(String routeName, String startRoute, String endRoute, LocalDateTime startTime) {
        super(routeName, startRoute, endRoute);
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public String getNextDeparture() {
        return "Маршрут Автобуса: " + getRouteName() + "," +
                " из " + getStartRoute() + "," +
                " в " + getEndRoute() + "," +
                " отправляется в " + getStartTime();
    }
}
