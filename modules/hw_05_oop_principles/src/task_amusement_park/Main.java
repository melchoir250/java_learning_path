package task_amusement_park;

public class Main {
    public static void main(String[] args) {
        AmusementPark amusementPark = new AmusementPark();

        Attraction roller_coaster = new RollerCoaster();
        amusementPark.setAttraction(roller_coaster);
        System.out.print("Американские горки - ");
        amusementPark.operateAttraction();


        Attraction carousel = new Carousel();
        amusementPark.setAttraction(carousel);
        System.out.print("Карусель - ");
        amusementPark.operateAttraction();
    }
}
