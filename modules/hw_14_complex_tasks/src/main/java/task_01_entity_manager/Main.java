package task_01_entity_manager;

public class Main {
    public static void main(String[] args) {
        EntityManager<Student> manager = new EntityManager<>();

        Student student1 = new Student(18, true, "Коля");
        Student student2 = new Student(20, true, "Аня");
        Student student3 = new Student(19, false, "Игорь");

        manager.add(student1);
        manager.add(student2);
        manager.add(student3);

        System.out.println("Список студентов:");
        for (Student student : manager.getAll()) {
            System.out.println(student);
        }

        System.out.println("Всего студентов: " + manager.getAll().size());
    }
}
