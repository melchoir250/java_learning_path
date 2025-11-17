package university;

public class University {
    static String universityName;
    final int studentID;
    String studentName;

    University(int someStudentID, String someStudentName) {
        this.studentID = someStudentID;
        this.studentName = someStudentName;
    }

    public static void changeUniversityName(String newUniversityName) {
        University.universityName = newUniversityName;
    }

    String getStudentName() {
        return this.studentName;
    }

    void printStudentInfo() {
        System.out.println("Name: " + getStudentName() + ", ID: " + this.studentID +
                ", University: " + University.universityName);
    }
}
