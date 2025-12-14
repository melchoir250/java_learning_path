package task_amusement_park;

public class Carousel implements Attraction{
    @Override
    public String info() {
        return "спокойный атракцион";
    }

    @Override
    public void maintrain() {
        System.out.println("Тех. обслуживание");
    }
}
