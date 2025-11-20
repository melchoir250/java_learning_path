package company;

public class Main {
    public static void main(String[] args) {
        Company human1 = new Company(45, "Михаил");
        Company human2 = new Company(49, "Владимир");
        Company human3 = new Company(67, "Вячеслав");
        human1.print();
        human2.print();
        human3.print();
        Company.companyName = "Банк";
        Company.printCompanyName();
        human2.setEmployeeName("Владимир Иванович");
        human3.setEmployeeName("Вячеслав Игоревич");
        human1.print();
        human2.print();
        human3.print();
//        human3.employeeID = 12; #TODO java: cannot assign a value to final variable employeeID
    }
}
