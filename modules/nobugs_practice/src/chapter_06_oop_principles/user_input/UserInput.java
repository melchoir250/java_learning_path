package chapter_06_oop_principles.user_input;


//36. Пользовательский ввод с валидацией (Инкапсуляция)
//Класс UserInput с методами readEmail(), readPhone() — валидация встроена.
//Ошибочные данные не сохраняются.
//Пояснение: защита от некорректных значений.


import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;
    private String email;
    private String phone;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readEmail() {
        while (true) {
            System.out.print("Введите email: ");
            String email = scanner.nextLine();

            if (email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
                this.email = email;
                return email;
            }

            System.out.println("Некорректный email. Попробуйте снова.");
        }
    }

    public String readPhone() {
        while (true) {
            System.out.print("Введите номер телефона: ");
            String phone = scanner.nextLine();

            if (phone != null && phone.matches("^(\\+7|8)\\d{10}$")) {
                this.phone = phone;
                return phone;
            }

            System.out.println("Некорректный номер. Введите в формате +7XXXXXXXXXX или 8XXXXXXXXXX");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
