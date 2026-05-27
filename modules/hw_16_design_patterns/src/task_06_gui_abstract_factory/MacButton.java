package task_06_gui_abstract_factory;

public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("[MacButton click] Клик");
    }
}