package chapter_06_oop_principles.transport_schedule;


public abstract class TransportSchedule {
    private final String routeName;
    private final String startRoute;
    private final String endRoute;

    public TransportSchedule(String routeName, String startRoute, String endRoute) {
        this.routeName = routeName;
        this.startRoute = startRoute;
        this.endRoute = endRoute;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getStartRoute() {
        return startRoute;
    }

    public String getEndRoute() {
        return endRoute;
    }

    public abstract String getNextDeparture();
}
