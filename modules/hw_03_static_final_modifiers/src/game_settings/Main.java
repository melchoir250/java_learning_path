package game_settings;

public class Main {
    public static void main(String[] args) {
        GameSettings game1 = new GameSettings("Догонялки", 20);
        GameSettings game2 = new GameSettings("Гонки", 4);
        game1.printGameStatus();
        game2.printGameStatus();
        GameSettings.setMaxPlayers(10);
        game1.addPlayers();
        game1.printGameStatus();
        game2.addPlayers();
        game2.printGameStatus();
    }
}
