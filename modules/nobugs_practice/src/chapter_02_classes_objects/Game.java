package chapter_02_classes_objects;

// Поля: title, genre (String).
// Метод start() печатает: Запуск игры <title> в жанре <genre>.

public class Game {
    String title;
    String genre;

    Game(String someTitle, String someGenre) {
        this.title = someTitle;
        this.genre = someGenre;
    }

    void start() {
        System.out.println("Запуск игры " + this.title + " в жанре " + this.genre);
    }

    public static void main(String[] args) {
        Game game1 = new Game("Тетрис", "Головоломка");
        game1.start();
    }
}
