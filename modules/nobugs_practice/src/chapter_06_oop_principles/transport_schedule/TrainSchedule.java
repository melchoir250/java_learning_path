package chapter_06_oop_principles.transport_schedule;

import java.time.LocalDateTime;

public class TrainSchedule extends TransportSchedule {
    private final LocalDateTime startTime;
    private final int numberPlatform;

    public TrainSchedule(String routeName, String startRoute, String endRoute,
                         LocalDateTime startTime, int numberPlatform) {
        super(routeName, startRoute, endRoute);
        this.startTime = startTime;
        this.numberPlatform = numberPlatform;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getNumberPlatform() {
        return numberPlatform;
    }

    @Override
    public String getNextDeparture() {
        return "Маршрут Поезда: " + getRouteName() + " ," +
                " из " + getStartRoute() + " ," +
                " в " + getEndRoute() + "," +
                " отправляется в " + getStartTime() +
                ", платформа номер: " + getNumberPlatform();
    }
}
