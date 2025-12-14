package task_amusement_park;

public class RollerCoaster implements Attraction {
    @Override
    public String info() {
        return "острые ощущения";
    }

    @Override
    public void maintrain() {
        System.out.println("Проверка безопасности");
    }
}
