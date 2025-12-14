package task_botanic_garden;

public class Main {
    public static void main(String[] args) {
        BotanicalGarden botanicalGarden = new BotanicalGarden();

        System.out.println("Создаем орхидею");

        Plant orchid = new Orchid();
        botanicalGarden.setPlant(orchid);
        botanicalGarden.maintainPlant();

        System.out.println("Создаем кактус");

        Plant cactus = new Cactus();
        botanicalGarden.setPlant(cactus);
        botanicalGarden.maintainPlant();
    }
}
