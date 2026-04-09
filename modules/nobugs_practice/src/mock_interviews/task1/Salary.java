package mock_interviews.task1;

import java.util.ArrayList;
import java.util.List;

public class Salary {
    private List<SalaryEmployee> salaryEmployees;

    public Salary() {
        this.salaryEmployees = new ArrayList<>();
    }

    public List<SalaryEmployee> getSalaryEmployees() {
        return salaryEmployees;
    }

    public void setSalaryEmployees(List<SalaryEmployee> salaryEmployees) {
        this.salaryEmployees = salaryEmployees;
    }

    public void addEmployee (SalaryEmployee e) {
        salaryEmployees.add(e);
    }

    public void getAll() {
        for (SalaryEmployee person : salaryEmployees) {
            System.out.println(person.getPersonName() + " получил " + person.calculateSalary());
        }
    }
}