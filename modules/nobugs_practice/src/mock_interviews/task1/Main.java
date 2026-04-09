package mock_interviews.task1;

public class Main {
    public static void main(String[] args) {
        FixSalary fixSalary = new FixSalary("Ivan", 33000);
        HoursSalary hoursSalary = new HoursSalary("Alex", 1000, 55);
        PercentSalary percentSalary = new PercentSalary("Victor", 10000, 6);

        Salary salary = new Salary();
        salary.addEmployee(fixSalary);
        salary.addEmployee(hoursSalary);
        salary.addEmployee(percentSalary);

        salary.getAll();
    }
}
