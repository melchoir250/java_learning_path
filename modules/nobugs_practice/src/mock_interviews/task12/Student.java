package mock_interviews.task12;

public class Student {
    private final String name;
    private final int numberRecordBook;
    private final double numberGPA;

    public Student(String name, int numberRecordBook, double numberGPA) {
        this.name = name;
        this.numberRecordBook = numberRecordBook;
        this.numberGPA = numberGPA;
    }

    public String getName() {
        return name;
    }

    public int getNumberRecordBook() {
        return numberRecordBook;
    }

    public double getNumberGPA() {
        return numberGPA;
    }

    @Override
    public String toString() {
        return getName() + ", Number Book: " + getNumberRecordBook() + ", GPA: " + getNumberGPA();
    }
}