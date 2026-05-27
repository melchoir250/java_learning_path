package task_06_gui_abstract_factory;


class Application {
    private Button button;
    private Window window;
    private Menu menu;

    public Application(GUIFactory factory) {
        this.window = factory.createWindow();
        this.menu = factory.createMenu();
        this.button = factory.createButton();
    }

    public void render() {
        window.draw();
        menu.select();
        button.click();
    }
}

public class Main {
    public static void main(String[] args) {
        GUIFactory windowsFactory = new WindowsFactory();
        Application winApp = new Application(windowsFactory);
        winApp.render();

        GUIFactory macFactory = new MacFactory();
        Application macApp = new Application(macFactory);
        macApp.render();
    }
}