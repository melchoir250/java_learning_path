package chapter_06_oop_principles.transport_schedule;

import java.time.LocalDateTime;

public class FlightSchedule extends TransportSchedule {
    private final LocalDateTime startTime;
    private final int terminal;
    private final int flightNumber;

    public FlightSchedule(String routeName, String startRoute, String endRoute,
                          LocalDateTime startTime, int terminal, int flightNumber) {
        super(routeName, startRoute, endRoute);
        this.startTime = startTime;
        this.terminal = terminal;
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getTerminal() {
        return terminal;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String getNextDeparture() {
        return "Маршрут Самолета: " + getRouteName() + " ," +
                " из " + getStartRoute() + " ," +
                " в " + getEndRoute() + "," +
                " отправляется в " + getStartTime() +
                ", номер терминала: " + getTerminal() +
                ", рейс номер: " + getFlightNumber();
    }
}
