package chapter_06_oop_principles.employees;


public class Developer extends Employee {
    double hourlyRate;
    int hoursWorked;

    Developer(double hourlyRate, int hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
