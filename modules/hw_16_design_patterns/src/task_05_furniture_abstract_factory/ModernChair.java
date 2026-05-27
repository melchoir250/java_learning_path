package task_05_furniture_abstract_factory;

public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Вы сели на удобный стул.");
    }
}