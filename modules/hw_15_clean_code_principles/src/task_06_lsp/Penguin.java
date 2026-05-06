package task_06_lsp;

public class Penguin extends Bird {
    public Penguin() {
        super("Пингвин");
    }

    public void swim() {
        System.out.println(getName() + " плывёт.");
    }
}