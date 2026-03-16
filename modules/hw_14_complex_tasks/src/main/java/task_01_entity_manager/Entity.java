package task_01_entity_manager;

public abstract class Entity {
    private final String name;
    private final int age;
    private final boolean isActive;

    public Entity(int age, boolean isActive, String name) {
        this.age = age;
        this.isActive = isActive;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }
}
