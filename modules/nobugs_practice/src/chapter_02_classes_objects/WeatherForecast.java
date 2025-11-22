package chapter_02_classes_objects;

public class WeatherForecast {
    int temperature;

    WeatherForecast(int someTemperature) {
        this.temperature = someTemperature;
    }

    boolean isCold() {
        return this.temperature < 5;
    }

    void printForecast() {
        System.out.println("Температура = " + this.temperature);
    }

    public static void main(String[] args) {
        WeatherForecast temp1 = new WeatherForecast(4);
        temp1.printForecast();
        System.out.println(temp1.isCold());
    }
}
