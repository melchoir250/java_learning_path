package chapter_06_oop_principles.ratable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ratable> allItems = List.of(
                new Movie("Inception", "2010", "Christopher Nolan", 8.8),
                new Movie("Interstellar", "2014", "Christopher Nolan", 8.6),
                new Movie("The Matrix", "1999", "Wachowski Sisters", 8.7),
                new Movie("Fight Club", "1999", "David Fincher", 8.8),

                new Book("1984", "George Orwell", "Dystopia", 9.0),
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 8.9),
                new Book("Clean Code", "Robert C. Martin", "Programming", 9.5),
                new Book("The Pragmatic Programmer", "Andrew Hunt", "Programming", 9.3),

                new Course("Java Basics", "John Smith", 8.5),
                new Course("Spring Boot Mastery", "Anna Brown", 9.1),
                new Course("Data Structures", "Mike Johnson", 8.9),
                new Course("System Design", "Alex Lee", 9.4)
        );
        RatingService ratingService = new RatingService();
        ratingService.filterTopRated(allItems);
    }
}