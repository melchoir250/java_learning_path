package task_05_furniture_abstract_factory;

public class ClassicChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Вы сели на тяжелый стул из дуба.");
    }
}