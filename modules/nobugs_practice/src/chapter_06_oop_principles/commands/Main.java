package chapter_06_oop_principles.commands;

public class Main {
    public static void main(String[] args) {
        PrintCommand printCommand = new PrintCommand();
        SaveCommand saveCommand = new SaveCommand();
        ExitCommand exitCommand = new ExitCommand();

        Button button = new Button(printCommand);
        button.click();
        button.setCommand(saveCommand);
        button.click();
        button.setCommand(exitCommand);
        button.click();
    }
}