package task_01_entity_manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EntityManagerTest {
    @Test
    public void addEntityTest() {
        EntityManager<Student> manager = new EntityManager<>();

        Student expectedStudent = new Student(18, true, "Коля");

        manager.add(expectedStudent);

        assertTrue(manager.getAll().contains(expectedStudent));

        Student actualStudent = manager.getAll().get(0);

        assertEquals(expectedStudent, actualStudent);

        assertEquals(1, manager.getAll().size());
    }
}