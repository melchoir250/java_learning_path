package student_group;

public class Main {
    public static void main(String[] args) {
        StudentGroup group_math = new StudentGroup("Математика", 22);
        group_math.printInfo();
        group_math.setGroupName("Физика");
        group_math.setStudentCount(19);
        group_math.printInfo();

        StudentGroup group_inform = new StudentGroup("Информатика", 15);
        group_inform.printInfo();
        group_inform.setGroupName("Информационные технологии");
        group_inform.setStudentCount(23);
        group_inform.printInfo();
    }
}
