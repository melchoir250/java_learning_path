package task_06_gui_abstract_factory;

public interface GUIFactory {
    Button createButton();
    Window createWindow();
    Menu createMenu();
}