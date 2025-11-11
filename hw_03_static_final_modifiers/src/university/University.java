package university;

public class University {
    static String universityName;
    final int studentID;
    String studentName;

    University(int someStudentID, String someStudentName) {
        this.studentID = someStudentID;
        this.studentName = someStudentName;
    }

    public static void changeUniversityName(String newName) {
        University.universityName = newName;
    }

    String getStudentName() {
        return this.studentName;
    }

    void printStudentInfo() {
        System.out.println("Имя: " + getStudentName() + ", ID: " + this.studentID +
                ", Университет: " + University.universityName);
    }
}
