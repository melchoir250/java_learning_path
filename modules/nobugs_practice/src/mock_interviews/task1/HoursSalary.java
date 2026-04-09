package mock_interviews.task1;

public class HoursSalary implements SalaryEmployee {
    private final String name;
    private double salaryHours;
    private double hours;

    public HoursSalary(String name, double salaryHours, double hours) {
        this.name = name;
        this.salaryHours = salaryHours;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public double getSalaryHours() {
        return salaryHours;
    }

    public double getHours() {
        return hours;
    }

    public void setSalaryHours(double salaryHours) {
        this.salaryHours = salaryHours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public double calculateSalary() {
        return getHours() * getSalaryHours();
    }

    @Override
    public String getPersonName() {
        return getName();
    }
}