package task_05_furniture_abstract_factory;

public class ClassicTable implements Table {
    @Override
    public void use() {
        System.out.println("Вы разложили бумаги на огромном антикварном столе.");
    }
}