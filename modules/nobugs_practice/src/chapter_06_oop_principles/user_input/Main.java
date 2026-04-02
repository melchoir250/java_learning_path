package chapter_06_oop_principles.user_input;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput(new Scanner(System.in));

        userInput.readEmail();
        userInput.readPhone();

        System.out.println("Email: " + userInput.getEmail());
        System.out.println("Phone: " + userInput.getPhone());
    }
}