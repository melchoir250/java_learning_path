package exceptions;


import java.util.Scanner;

public class AgeValidator {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        try {
            ageValidator(age);
            System.out.println("Возраст корректный");
        } catch (InvalidAgeException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void ageValidator(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Возраст должен быть от 0 до 150");
        }
    }
}
