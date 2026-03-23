package chapter_06_oop_principles.ratable;

public class Course implements Ratable {
    private final String title;
    private final String instructor;
    private final double rating;

    public Course(String title, String instructor, double rating) {
        this.title = title;
        this.instructor = instructor;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", instructor='" + instructor + '\'' +
                ", rating=" + rating +
                '}';
    }
}