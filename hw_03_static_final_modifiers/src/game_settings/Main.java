package game_settings;

public class Main {
    public static void main(String[] args) {
        GameSettings game1 = new GameSettings("Тетрис", 3);
        GameSettings game2 = new GameSettings("Догонялки", 15);
        game1.printGameStatus();
        game2.printGameStatus();
        GameSettings.setMaxPlayers(10);
        game1.addPlayer();
        game1.printGameStatus();
        game2.addPlayer();
        game2.printGameStatus();
    }
}
