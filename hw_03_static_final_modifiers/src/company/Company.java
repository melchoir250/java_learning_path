package company;

public class Company {
    static String companyName;
    final int employeeID;
    String employeeName;

    Company(int someEmployeeID, String someEmployeeName) {
        this.employeeID = someEmployeeID;
        this.employeeName = someEmployeeName;
    }

    public static void printCompanyName() {
        System.out.println("companyName: " + companyName);
    }

    String getEmployeeName() {
        return this.employeeName;
    }

    void setEmployeeName(String newEmployeeName) {
        this.employeeName = newEmployeeName;
    }

    void print() {
        System.out.println("companyName: " + companyName + ", employeeName: " + getEmployeeName() + ", employeeID: " + this.employeeID);
    }
}
