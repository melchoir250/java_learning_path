package task_05_furniture_abstract_factory;

public class ModernTable implements Table {
    @Override
    public void use() {
        System.out.println("Вы работаете за стеклянным столом.");
    }
}