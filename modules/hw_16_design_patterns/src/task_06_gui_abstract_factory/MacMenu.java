package task_06_gui_abstract_factory;

public class MacMenu implements Menu {
    @Override
    public void select() {
        System.out.println("[MacMenu select] Открывается список настроек");
    }
}