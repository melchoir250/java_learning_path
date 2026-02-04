package exceptions;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        try {
            emailValidotor(email);
            System.out.println("Email valid");
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void emailValidotor(String email) {
        String reg = "[A-Za-z]+[@A-Za-z]";

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidEmailException("Некорректный Email");
        }
    }
}
