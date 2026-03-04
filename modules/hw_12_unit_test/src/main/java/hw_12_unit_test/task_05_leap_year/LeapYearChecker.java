package hw_12_unit_test.task_05_leap_year;

public class LeapYearChecker {
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
