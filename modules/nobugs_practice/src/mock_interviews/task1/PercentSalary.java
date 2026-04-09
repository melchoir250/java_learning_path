package mock_interviews.task1;

public class PercentSalary implements SalaryEmployee {
    private final String name;
    private double salary;
    private double percentSale;

    public PercentSalary(String name, double salary, double percentSale) {
        this.name = name;
        this.salary = salary;
        this.percentSale = percentSale;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getPercentSale() {
        return percentSale;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPercentSale(double percentSale) {
        this.percentSale = percentSale;
    }

    @Override
    public double calculateSalary() {
        return getSalary() * getPercentSale();
    }

    @Override
    public String getPersonName() {
        return getName();
    }
}