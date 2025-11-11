package company;

public class Main {
    public static void main(String[] args) {
        Company human1 = new Company(34, "Петр");
        Company human2 = new Company(746, "Марк");
        Company human3 = new Company(453, "Иван");
        human1.print();
        human3.print();
        human2.print();
        Company.companyName = "Банк";
        Company.printCompanyName();
        human2.setEmployeeName("Марк Валерьевич");
        human3.setEmployeeName("Иван Григорьевич");
        human1.print();
        human3.print();
        human2.print();
//        human3.employeeID = 12; #TODO java: cannot assign a value to final variable employeeID
    }
}