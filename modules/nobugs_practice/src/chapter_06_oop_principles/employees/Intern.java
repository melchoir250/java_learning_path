package chapter_06_oop_principles.employees;


class Intern extends Employee {
    double stipend;

    Intern(double stipend) {
        this.stipend = stipend;
    }

    @Override
    double calculateSalary() {
        return stipend;
    }
}
