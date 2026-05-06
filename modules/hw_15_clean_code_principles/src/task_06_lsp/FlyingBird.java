package task_06_lsp;

public class FlyingBird extends Bird implements Flyable {
    public FlyingBird() {
        super("Воробей");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " летит.");
    }
}