package task_museum;

public class Manuscript implements Exhibit{
    @Override
    public String describe() {
        return "древний текст";
    }

    @Override
    public void preserve() {
        System.out.println("контролируемая влажность");
    }
}
