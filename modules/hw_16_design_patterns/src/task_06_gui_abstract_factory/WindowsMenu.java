package task_06_gui_abstract_factory;

public class WindowsMenu implements Menu {
    @Override
    public void select() {
        System.out.println("[WindowsMenu select] Открывается список настроек");
    }
}