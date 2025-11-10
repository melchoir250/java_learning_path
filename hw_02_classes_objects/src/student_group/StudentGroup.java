package student_group;

public class StudentGroup {
    String groupName;
    int studentCount;

    StudentGroup(String someGroupName, int someStudentCount) {
        this.groupName = someGroupName;
        this.studentCount = someStudentCount;
    }

    int getStudentCount() {

        return this.studentCount;
    }

    String getGroupName() {

        return this.groupName;
    }

    void setStudentCount(int newStudentCount) {

        this.studentCount = newStudentCount;
    }

    void setGroupName(String newGroupName) {

        this.groupName = newGroupName;
    }

    void printInfo() {
        System.out.println("Название группы: " + getGroupName() + ", количество студентов: " + getStudentCount());
    }
}
