package chapter_06_oop_principles.employees;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static double calculateTotalSalary(List<Employee> employees) {
        double total = 0;

        for (Employee e : employees) {
            total += e.calculateSalary();
        }

        return total;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Manager(5000, 1500));
        employees.add(new Developer(40, 160));
        employees.add(new Intern(800));

        double totalSalary = calculateTotalSalary(employees);

        System.out.println("Total salary: " + totalSalary);
    }
}