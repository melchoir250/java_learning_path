package mock_interviews.task1;

public class FixSalary implements SalaryEmployee {
    private final String name;
    private double salary;

    public FixSalary(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return getSalary();
    }

    @Override
    public String getPersonName() {
        return getName();
    }
}