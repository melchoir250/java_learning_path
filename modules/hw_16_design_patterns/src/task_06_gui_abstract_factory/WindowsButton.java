package task_06_gui_abstract_factory;

public class WindowsButton implements  Button {
    @Override
    public void click() {
        System.out.println("[WindowsButton click] Клик");
    }
}