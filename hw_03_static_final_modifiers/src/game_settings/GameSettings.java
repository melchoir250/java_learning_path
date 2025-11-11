package game_settings;

public class GameSettings {
    static int maxPlayers;
    final String gameName;
    int currentPlayers;

    GameSettings(String someGameName, int someCurrentPlayers) {
        this.gameName = someGameName;
        this.currentPlayers = someCurrentPlayers;
    }

    static void setMaxPlayers(int newMaxPlayers) {
        GameSettings.maxPlayers = newMaxPlayers;
    }

    void addPlayer() {
        this.currentPlayers ++;
        this.currentPlayers = Math.min(GameSettings.maxPlayers, this.currentPlayers);
    }

    void printGameStatus() {
        System.out.println("Название игры: " + this.gameName + ", Текущее количество игроков: " + this.currentPlayers
                + ", Макс.кол-во игроков: " + GameSettings.maxPlayers);
    }
}
