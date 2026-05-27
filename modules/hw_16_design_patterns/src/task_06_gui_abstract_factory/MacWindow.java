package task_06_gui_abstract_factory;

public class MacWindow implements Window {
    @Override
    public void draw() {
        System.out.println("[MacWindow draw] Окно с кнопкой Свернуть/Развернуть");
    }
}