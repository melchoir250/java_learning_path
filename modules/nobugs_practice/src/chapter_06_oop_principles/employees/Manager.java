package chapter_06_oop_principles.employees;


class Manager extends Employee {
    double baseSalary;
    double bonus;

    Manager(double baseSalary, double bonus) {
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return baseSalary + bonus;
    }
}


