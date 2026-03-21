package chapter_06_oop_principles.commands;

public class SaveCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Сохраняем документ");
    }
}