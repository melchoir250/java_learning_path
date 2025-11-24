package switch_task;

public class LetterGradeConverter {
    public static String GradeConvert(int grade) {
            if (grade <= 100 && grade >= 90) {
                return "A";
            } else if (grade < 90 && grade >= 80) {
                return "B";
            } else if (grade < 80 && grade >= 70) {
                return "C";
            } else if (grade < 70 && grade >= 60) {
                return "D";
            } else if (grade < 60 && grade >= 0) {
                return "F";
            } else {
                return "Такого числа за тест не может существовать.";
            }
        }

    public static void main(String[] args) {
        System.out.println(GradeConvert(100));
        System.out.println(GradeConvert(86));
        System.out.println(GradeConvert(77));
        System.out.println(GradeConvert(66));
        System.out.println(GradeConvert(33));
        System.out.println(GradeConvert(123));
    }
}
