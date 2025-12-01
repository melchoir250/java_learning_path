package chapter_03_static_final;

// Создай структуру, где для каждой планеты задана гравитационная константа.
//На основе этих данных должен работать метод, который по массе и имени планеты
//возвращает вес объекта.
//Пояснение: константы должны быть доступны без создания объекта и не меняться во
//время работы.

public class GravityPlanet {
    static final double GRAVITY_MARS = 2.1;
    static final double GRAVITY_EARTH = 1.0;
    static final double GRAVITY_PLUTON = 12.9;
    int mass_planet;
    String name_planet;

    GravityPlanet(int someMassPlanet, String someNamePlanet) {
        this.mass_planet = someMassPlanet;
        this.name_planet = someNamePlanet;
    }

    double getGravityPlanetMars() {
        return mass_planet * GRAVITY_MARS;
    }

    double getGravityPlanetEARTH() {
        return mass_planet * GRAVITY_EARTH;
    }

    double getGravityPlanetPLUTON() {
        return mass_planet * GRAVITY_PLUTON;
    }

    public static void main(String[] args) {
        GravityPlanet mars = new GravityPlanet(100, "Mars");
        System.out.println(mars.getGravityPlanetMars() + " " + mars.name_planet);

        GravityPlanet earth = new GravityPlanet(210, "Earth");
        System.out.println(earth.getGravityPlanetEARTH() + " " + earth.name_planet);

        GravityPlanet pluton = new GravityPlanet(14, "Pluton");
        System.out.println(pluton.getGravityPlanetPLUTON() + " " + pluton.name_planet);
    }
}
