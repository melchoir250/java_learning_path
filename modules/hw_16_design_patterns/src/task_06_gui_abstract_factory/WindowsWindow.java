package task_06_gui_abstract_factory;

public class WindowsWindow implements Window {
    @Override
    public void draw() {
        System.out.println("[WindowsWindow draw] Окно с кнопкой Свернуть/Развернуть");
    }
}