package chapter_06_oop_principles.commands;

public class PrintCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Документ отправлен на печать");
    }
}
