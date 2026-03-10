package chapter_06_oop_principles.lessons;

public class Main {

    public static void calculateTotalDuration(Lesson[] lessons) {

        int total = 0;

        for (Lesson lesson : lessons) {
            total += lesson.getDuration();
        }

        System.out.println("Общая длительность курса: " + total + " мин.");
    }

    public static void main(String[] args) {

        Lesson[] lessons = {
                new VideoLesson("Введение в Java", 30),
                new LiveSession("Разбор задач", 10, 70),
                new HomeworkLesson("Домашнее задание 1", 45)
        };

        calculateTotalDuration(lessons);
    }
}
